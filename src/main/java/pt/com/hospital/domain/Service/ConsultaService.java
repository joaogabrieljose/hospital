package pt.com.hospital.domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.domain.entity.Consulta;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.entity.Paciente;
import pt.com.hospital.domain.repository.ConsultaRepository;
import pt.com.hospital.domain.repository.MedicoRepository;
import pt.com.hospital.domain.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // agendar consulta
    public Consulta agendaConsulta(long medicoId, long pacienteId, LocalDateTime dataHora, String motivo){
        Paciente paciente = pacienteRepository.findPacienteById(pacienteId)
                .orElseThrow(()-> new RuntimeException("paciente não encontrado"));
        Medico medico = medicoRepository.findMedicoById(medicoId)
                .orElseThrow(()-> new RuntimeException("medio não encontrado"));
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(dataHora);
        consulta.setMotivoConsulta(motivo);
        consulta.setStatus("Agendar");
        consulta.setDataCadastro(LocalDateTime.now());
        return  consultaRepository.save(consulta);
    }

    public List<Consulta> findAll(){
        return (List<Consulta>) consultaRepository.findAll();
    }

    // atualizarStatusConsulta
    public Consulta updateStatusConsulta(long id, String status){
        Consulta consulta = consultaRepository.findConsultaById(id)
                .orElseThrow(()-> new RuntimeException("consulta não encontrada"));
        consulta.setStatus(status);
        return  consultaRepository.save(consulta);
    }

    // cancela consulta
    public void cancelaConsulta(long id){
        consultaRepository.deleteById(id);
    }

}
