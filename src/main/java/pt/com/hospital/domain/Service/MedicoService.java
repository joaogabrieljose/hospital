package pt.com.hospital.domain.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.repository.MedicoRepository;

import java.util.List;

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

    public Medico update(long id, Medico medicoAtualizado) {
        Medico medicoExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com id: " + id));

        medicoExistente.setName(medicoAtualizado.getName());
        medicoExistente.setEspecialidade(medicoAtualizado.getEspecialidade());
        medicoExistente.setTelefone(medicoAtualizado.getTelefone());
        medicoExistente.setEmail(medicoAtualizado.getEmail());
        medicoExistente.setEndereco(medicoAtualizado.getEndereco());
        medicoExistente.setDataCadastro(medicoAtualizado.getDataCadastro());
        return repository.save(medicoExistente);
    }

    public void deleteMedicoById(long id){
        Medico medico = getMedicoById(id);
        repository.delete(medico);
    }

}
