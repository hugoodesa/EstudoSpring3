package br.com.alura.medclinica.Controller;

import br.com.alura.medclinica.Service.BasicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class DefaultController<Service extends BasicService<DTO, DTOAtualiza>, DTO, DTOAtualiza> {

    private Service service;

    public DefaultController(Service service) {
        this.service = service;
    }

    public ResponseEntity post(DTO dto, UriComponentsBuilder uri){
        return this.service.post(dto, uri);
    };

    public ResponseEntity delete(Long id){
        return this.service.delete(id);
    };

    public ResponseEntity select(Long id){
        return  this.service.select(id);
    }

    public ResponseEntity update(Long id, DTOAtualiza medicoDTO){
        return this.service.update(id, medicoDTO);
    }

    public Page<DTO> selectAll(Pageable pageable){
        return  this.service.selectAll(pageable);
    }

}
