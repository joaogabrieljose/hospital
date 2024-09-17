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
import java.util.Optional;

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
    public PacienteResponse getPacienteById(long id) {
        Optional<Paciente> paciente = repository.findPacienteById(id);
        Paciente get = paciente.orElseThrow(()-> new EntityNotFoundException("paciente não existe"));
        return PacienteMapper.toPacienteResponse(get);
    }

    // atualizar por id
    public PacienteResponse updateById(long id, PacienteRequest paciente) {
        Optional<Paciente> update = repository.findPacienteById(id);
        Paciente novo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("paciente não encontrado com id: " + id));
        novo.setName(paciente.getName());
        novo.setEmail(paciente.getEmail());
        novo.setSexo(paciente.getSexo());
        novo.setTelefone(paciente.getTelefone());
        novo.setDataNascimento(paciente.getDataNascimento());
        novo.setDataCadastro(paciente.getDataCadastro());

        Paciente atualizado = repository.save(novo);
        return PacienteMapper.toPacienteResponse(atualizado);
    }

    //delete
    public boolean deleteById(long id) {
       Optional<Paciente> paciente = repository.findPacienteById(id);
       if (paciente.isPresent()){
           repository.deleteById(id);
           return true;
       }
       return  false;
    }
}
