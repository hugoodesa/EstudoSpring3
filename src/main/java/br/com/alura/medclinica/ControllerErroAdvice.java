package br.com.alura.medclinica;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerErroAdvice {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entidadeNaoEncontrada(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity campoInvalido(){
        return ResponseEntity.badRequest().build();
    }

}
