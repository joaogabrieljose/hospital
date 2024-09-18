package pt.com.hospital.domain.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.application.DTO.mapper.ConsultaMapper;
import pt.com.hospital.application.DTO.request.ConsultaRequest;
import pt.com.hospital.application.DTO.response.ConsultaResponse;
import pt.com.hospital.domain.entity.Consulta;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.entity.Paciente;
import pt.com.hospital.domain.repository.ConsultaRepository;
import pt.com.hospital.domain.repository.MedicoRepository;
import pt.com.hospital.domain.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // agendar consulta
    public ConsultaResponse create(ConsultaRequest request){
        var consulta = ConsultaMapper.toConsulta(request);
        var novaConsulta = consultaRepository.save(consulta);
        return ConsultaMapper.toConsultaResponse(novaConsulta);
    }

    public List<ConsultaResponse> findAll(){
        List<Consulta> consulta = (List<Consulta>)  consultaRepository.findAll();
        List<ConsultaResponse> findConsulta = consulta.stream()
                .map(ConsultaMapper::toConsultaResponse).toList();
        return findConsulta;
    }


    public ConsultaResponse updateConsulta(long id, ConsultaRequest consulta) {
        Consulta consultaExistente = consultaRepository.findConsultaById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com id: " + id));

        Medico updateMedico = medicoRepository.findMedicoById(consulta.getMedicoId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com id: " + consulta.getMedicoId()));
        consultaExistente.setMedico(updateMedico);

        Paciente updatePaciente = pacienteRepository.findPacienteById(consulta.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com id: " + consulta.getPacienteId()));
        consultaExistente.setPaciente(updatePaciente);

        consultaExistente.setDataHora(consulta.getDataHora());
        consultaExistente.setMotivoConsulta(consulta.getMotivoConsulta());
        consultaExistente.setStatus(consulta.getStatus());

        Consulta consultaAtualizada = consultaRepository.save(consultaExistente);

        return ConsultaMapper.toConsultaResponse(consultaAtualizada);
    }


    // cancela consulta
    public boolean cancelaConsulta(long id){
        Optional<Consulta> consulta = consultaRepository.findConsultaById(id);
        if (consulta.isPresent()){
            consultaRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
