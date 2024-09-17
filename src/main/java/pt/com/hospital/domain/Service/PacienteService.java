package pt.com.hospital.domain.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.application.DTO.mapper.PacienteMapper;
import pt.com.hospital.application.DTO.request.PacienteRequest;
import pt.com.hospital.application.DTO.response.PacienteResponse;
import pt.com.hospital.domain.entity.Paciente;
import pt.com.hospital.domain.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    //create paciente
    public PacienteResponse createPaciente(PacienteRequest request) {
        var paciente = PacienteMapper.toPaciente(request);
        var create = repository.save(paciente);
        return PacienteMapper.toPacienteResponse(create);
    }

    // lista paciente
    public List<PacienteResponse> findAll() {
        List<Paciente> paciente = (List<Paciente>) repository.findAll();
        List<PacienteResponse> findPaciente = paciente.stream()
                .map(PacienteMapper::toPacienteResponse).toList();
        return findPaciente;
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
