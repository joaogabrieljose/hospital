package pt.com.hospital.domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.domain.entity.Paciente;
import pt.com.hospital.domain.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    //create paciente
    public Paciente createPaciente(Paciente paciente){
        return repository.save(paciente);
    }

    // lista paciente
    public List<Paciente> findAll(){
        return (List<Paciente>) repository.findAll();
     }

     // salva paciente por id
    public Paciente getPacienteById(long id){
        return repository.findPacienteById(id).orElseThrow(()-> new RuntimeException("paciente não encontrado"));
    }
    // atualizar por id

    public Paciente updateById(long id, Paciente paciente){
        Optional<Paciente> update = repository.findPacienteById(id);
        if(update.isPresent()){
            Paciente newUpdate = update.get();
            newUpdate.setId(paciente.getId());
            newUpdate.setName(paciente.getName());
            newUpdate.setEmail(paciente.getEmail());
            newUpdate.setSexo(paciente.getSexo());
            newUpdate.setTelefone(paciente.getTelefone());
            newUpdate.setConsulta(paciente.getConsulta());
            newUpdate.setDataNascimento(paciente.getDataNascimento());
            newUpdate.setDataCadastro(paciente.getDataCadastro());
            return  newUpdate;
        }else {
            paciente.setId(id);
            return paciente;
        }

    }

    //delete
   public void deleteById(long id){
        Paciente paciente = getPacienteById(id);
        repository.delete(paciente);
   }



}
