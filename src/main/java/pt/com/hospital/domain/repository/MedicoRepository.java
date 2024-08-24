package pt.com.hospital.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.hospital.domain.entity.Medico;

import java.util.Optional;

public interface MedicoRepository extends CrudRepository<Medico,Long> {
    Optional<Medico> findMedicoBy(long id);
}
