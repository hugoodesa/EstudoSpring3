package br.com.alura.medclinica.DTO;

import br.com.alura.medclinica.Enums.Especialidade;
import br.com.alura.medclinica.Model.Endereco;
import br.com.alura.medclinica.Model.Medico;

public record MedicoDTOResponse(Long id,String nome, String telefone, String email, String crm, Endereco endereco, Especialidade especialidade) {

    public MedicoDTOResponse(Medico medico) {
        this(medico.getId(),medico.getNome(),medico.getTelefone(),medico.getEmail(), medico.getCrm(),medico.getEndereco(),medico.getEspecialidade());
    }
}
