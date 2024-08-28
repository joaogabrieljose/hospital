package pt.com.hospital.domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import pt.com.hospital.domain.entity.Consulta;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.entity.Paciente;
import pt.com.hospital.domain.repository.ConsultaRepository;
import pt.com.hospital.domain.repository.MedicoRepository;
import pt.com.hospital.domain.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // agendar consulta
    public Consulta agendaConsulta(Consulta consulta) {
        Paciente paciente = pacienteRepository.findPacienteById(consulta.getPaciente().getId())
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado"));
        Medico medico = medicoRepository.findMedicoById(consulta.getMedico().getId())
                .orElseThrow(() -> new NoSuchElementException("Médico não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setStatus("Agendada");
        consulta.setDataCadastro(LocalDateTime.now());
        return consultaRepository.save(consulta);
    }

    public List<Consulta> findAll(){
        return (List<Consulta>) consultaRepository.findAll();
    }


    @PutMapping("/consulta/{id}")
    public Consulta updateConsulta(long id, Consulta consulta) {
        Consulta consultaExistente = consultaRepository.findConsultaById(id)
                .orElseThrow(() -> new NoSuchElementException("Consulta não encontrada com id: " + id));

        consultaExistente.setMedico(consulta.getMedico());
        consultaExistente.setPaciente(consulta.getPaciente());
        consultaExistente.setDataHora(consulta.getDataHora());
        consultaExistente.setMotivoConsulta(consulta.getMotivoConsulta());
        consultaExistente.setStatus(consulta.getStatus());

        return consultaRepository.save(consultaExistente);
    }

    // cancela consulta
    public void cancelaConsulta(long id){
        consultaRepository.deleteById(id);
    }

}
