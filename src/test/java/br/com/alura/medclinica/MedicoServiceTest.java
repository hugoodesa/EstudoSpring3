package br.com.alura.medclinica;

import br.com.alura.medclinica.DTO.MedicoDTOResponse;
import br.com.alura.medclinica.Service.MedicoService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MedicoServiceTest {


    @Autowired
    MedicoService service;

    @Test
    public void deveBuscarUmMedico() throws Exception{

        Long id = 1L;

        ResponseEntity<MedicoDTOResponse> medico = this.service.select(id);

        assertTrue(medico.getStatusCode().equals(HttpStatus.OK));
        assertEquals(medico.getBody().nome(),"Alexson");

    }

    @Test
    public void deveLancarUmaException() throws Exception{

        Long id = 99L;

        assertThrows(EntityNotFoundException.class,()->{
            ResponseEntity<MedicoDTOResponse> medico = this.service.select(id);
        });
    }

}
