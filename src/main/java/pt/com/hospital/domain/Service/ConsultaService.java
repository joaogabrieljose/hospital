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

    // Método no serviço para atualizar a consulta
    public Consulta updateConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // Método para atualizar apenas o status da consulta
    public Consulta updateStatusConsulta(long id, String status) {
        Consulta consulta = consultaRepository.findConsultaById(id)
                .orElseThrow(() -> new NoSuchElementException("Consulta não encontrada com id: " + id));

        consulta.setStatus(status);
        return consultaRepository.save(consulta);
    }

    // cancela consulta
    public void cancelaConsulta(long id){
        consultaRepository.deleteById(id);
    }

}
