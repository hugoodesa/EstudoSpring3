package br.com.alura.medclinica.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface BasicService<DTO,DTOAtualiza> {

    ResponseEntity post(DTO dto, UriComponentsBuilder uri);
    ResponseEntity delete(Long id);
    ResponseEntity select(Long id);
    Page<DTO> selectAll(Pageable pageable);
    ResponseEntity update(Long id, DTOAtualiza medicoDTO);

}
