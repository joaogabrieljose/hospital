package pt.com.hospital.DTO.request;

import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.entity.Paciente;

import java.time.LocalDateTime;

public class ConsultaRequest {
    public Long id;
    public Paciente paciente;
    public Medico medico;
    public LocalDateTime dataHora;
    public String motivoConsulta;
    public String status;
    public LocalDateTime dataCadastro;

    public ConsultaRequest(){}

    public ConsultaRequest(Long id, Paciente paciente, Medico medico, LocalDateTime dataHora,
                           String motivoConsulta, String status, LocalDateTime dataCadastro) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.motivoConsulta = motivoConsulta;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
