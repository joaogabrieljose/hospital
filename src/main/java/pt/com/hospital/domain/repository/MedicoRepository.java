package pt.com.hospital.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.com.hospital.domain.entity.Medico;

import java.util.Optional;
@Repository
public interface MedicoRepository extends CrudRepository<Medico,Long> {
    Optional<Medico> findMedicoById(long id);
}
