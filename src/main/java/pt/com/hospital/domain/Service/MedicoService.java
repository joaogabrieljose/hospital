package pt.com.hospital.domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;


    //cria medico
    public Medico create (Medico medico){
        return repository.save(medico);
    }

    public Medico getMedicoById(long id){
        return repository.findMedicoById(id).orElseThrow(()-> new RuntimeException("medico não encontrado"));
    }

    public List<Medico> findAll(){
        return  (List<Medico>) repository.findAll();
    }

    public Medico update(long id, Medico medico){
        Optional<Medico> update = repository.findMedicoById(id);
        if(update.isPresent()){
            Medico newUpdate = update.get();
            newUpdate.setId(medico.getId());
            newUpdate.setName(medico.getName());
            newUpdate.setEmail(medico.getEmail());
            newUpdate.setTelefone(medico.getTelefone());
            newUpdate.setEndereco(medico.getEndereco());
            newUpdate.setEspecialidade(medico.getEspecialidade());
            newUpdate.setConsulta(medico.getConsulta());
            newUpdate.setDataCadastro(medico.getDataCadastro());
            return  newUpdate;
        }else {
            medico.setId(id);
            return repository.save(medico);
        }
    }

    public void deleteById(long id){
        Medico medico = getMedicoById(id);
        repository.delete(medico);
    }

}
