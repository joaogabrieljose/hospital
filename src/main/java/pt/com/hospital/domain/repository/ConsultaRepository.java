package pt.com.hospital.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.com.hospital.domain.entity.Consulta;

import java.util.Optional;
@Repository
public interface ConsultaRepository extends CrudRepository<Consulta,Long> {
    Optional<Consulta> findConsultaById(long id);
}
