package br.com.alura.medclinica.DTO;

import br.com.alura.medclinica.Enums.Especialidade;
import br.com.alura.medclinica.Model.Endereco;
import br.com.alura.medclinica.Model.Medico;
import br.com.alura.medclinica.Service.MedicoDTOAtualiza;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {

    private String nome;
    private String crm;
    private String telefone;
    @Email
    private String email;
    private Especialidade especialidade;
    private EnderecoDTO endereco;

    public MedicoDTO(Medico medico) {
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.telefone = medico.getTelefone();
        this.email = medico.getEmail();
        this.especialidade = medico.getEspecialidade();
        this.endereco = new EnderecoDTO(medico.getEndereco());
    }
}
