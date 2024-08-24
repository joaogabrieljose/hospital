package pt.com.hospital.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.hospital.domain.entity.Consulta;

import java.util.Optional;

public interface ConsultaRepository extends CrudRepository<Consulta,Long> {
    Optional<Consulta> findConsultaBy(long id);
}
