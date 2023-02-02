package br.com.alura.medclinica;

import br.com.alura.medclinica.DTO.EnderecoDTO;
import br.com.alura.medclinica.DTO.MedicoDTO;
import br.com.alura.medclinica.Enums.Especialidade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureMockMvc
@SpringBootTest
public class MedicoControllerTest {

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void deveCadastrarUmMedico() throws Exception {

        URI uri = new URI("/medico");

        var medico = new MedicoDTO("Hugo Luiz","1234","4899996666","hugoodesa@gmail.com", Especialidade.CARDIOLOGIA,
                new EnderecoDTO("rua ABC",12,"Gruta","Santa Lúcia","Capivari de Baixo","SC","88745000"));

        var json = mapper.writeValueAsString(medico);

        var resposta = mock.perform(post(uri)
         .contentType(MediaType.APPLICATION_JSON)
         .content(json))
         .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
         .andReturn().getResponse().getContentAsString();

        MedicoDTO med = mapper.readValue(resposta, MedicoDTO.class);

        assertEquals(med.getNome(),"Hugo Luiz");
    }


}
