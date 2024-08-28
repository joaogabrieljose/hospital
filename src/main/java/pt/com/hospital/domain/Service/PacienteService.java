package pt.com.hospital.domain.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.domain.entity.Paciente;
import pt.com.hospital.domain.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    //create paciente
    public Paciente createPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    // lista paciente
    public List<Paciente> findAll() {
        return (List<Paciente>) repository.findAll();
    }

    // salva paciente por id
    public Paciente getPacienteById(long id) {
        return repository.findPacienteById(id).orElseThrow(() -> new RuntimeException("paciente não encontrado"));
    }

    // atualizar por id
    public Paciente updateById(long id, Paciente paciente) {
        // Optional<Paciente> update = repository.findPacienteById(id);
        Paciente novo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("paciente não encontrado com id: " + id));
        novo.setName(paciente.getName());
        novo.setEmail(paciente.getEmail());
        novo.setSexo(paciente.getSexo());
        novo.setTelefone(paciente.getTelefone());
        novo.setDataNascimento(paciente.getDataNascimento());
        novo.setDataCadastro(paciente.getDataCadastro());
        return repository.save(novo);
    }

    //delete
    public void deleteById(long id) {
        Paciente paciente = getPacienteById(id);
        repository.delete(paciente);
    }


}
