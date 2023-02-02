package br.com.alura.medclinica.Model;

import br.com.alura.medclinica.DTO.MedicoDTO;
import br.com.alura.medclinica.Enums.Especialidade;
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
@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;

    private String telefone;

    @Email
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medicoDTO) {
        this.crm = medicoDTO.getCrm();
        this.nome = medicoDTO.getNome();
        this.telefone = medicoDTO.getTelefone();
        this.email = medicoDTO.getEmail();
        this.especialidade = medicoDTO.getEspecialidade();
        this.endereco = new Endereco(medicoDTO.getEndereco());
    }

    public void atualizar(MedicoDTOAtualiza medicoDTO) {
        this.crm = medicoDTO.crm();
        this.telefone = medicoDTO.telefone();
        this.nome = medicoDTO.nome();
    }
}
