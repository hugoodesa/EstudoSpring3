package br.com.alura.medclinica.Service;

import br.com.alura.medclinica.DTO.MedicoDTO;
import br.com.alura.medclinica.DTO.MedicoDTOResponse;
import br.com.alura.medclinica.Model.Medico;
import br.com.alura.medclinica.Repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MedicoService implements BasicService<MedicoDTO, MedicoDTOAtualiza>{

    @Autowired
    MedicoRepository repository;

    @Override
    @Transactional
    public ResponseEntity<MedicoDTOResponse> post(MedicoDTO medicoDTO, UriComponentsBuilder uriBuilder) {
        Medico medico = this.repository.save(new Medico(medicoDTO));

        URI uri = uriBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoDTOResponse(medico));
    }

    @Override
    @Transactional
    public ResponseEntity delete(Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<MedicoDTOResponse> select(Long id) {
        //Medico medico = this.repository.getReferenceById(id);

        Medico medico = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("não encontrado"));

        return ResponseEntity.ok(new MedicoDTOResponse(medico));
    }

    @Override
    public Page<MedicoDTO> selectAll(Pageable pageable) {
        return new PageImpl<>(this.repository.findAll(pageable).stream().map(MedicoDTO::new).toList());
    }

    @Override
    @Transactional
    public ResponseEntity update(Long id, MedicoDTOAtualiza medicoDTO) {
        Medico medico = this.repository.getReferenceById(id);
        medico.atualizar(medicoDTO);

        return ResponseEntity.ok(new MedicoDTO(medico));
    }

}
