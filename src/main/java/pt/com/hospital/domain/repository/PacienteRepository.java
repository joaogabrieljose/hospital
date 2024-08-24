package pt.com.hospital.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.com.hospital.domain.entity.Paciente;

import java.util.Optional;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    Optional<Paciente> findPacienteById(long id);
}
