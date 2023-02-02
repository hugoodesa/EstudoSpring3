package br.com.alura.medclinica.Controller;

import br.com.alura.medclinica.DTO.MedicoDTO;
import br.com.alura.medclinica.Service.MedicoDTOAtualiza;
import br.com.alura.medclinica.Service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medico")
public class MedicoController extends DefaultController<MedicoService , MedicoDTO, MedicoDTOAtualiza> {

    @Autowired
    MedicoService service;

    public MedicoController(MedicoService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity post(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uri) {
        return super.post(medicoDTO,uri);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Long id) {
        return super.select(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody @Valid MedicoDTOAtualiza medicoDTO) {
        return super.update(id, medicoDTO);
    }

    @Override
    @GetMapping
    public Page<MedicoDTO> selectAll(@PageableDefault(size = 10 , sort = "nome") Pageable pageable) {
        return super.selectAll(pageable);
    }
}
