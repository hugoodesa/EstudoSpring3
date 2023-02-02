package br.com.alura.medclinica.Repository;

import br.com.alura.medclinica.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}