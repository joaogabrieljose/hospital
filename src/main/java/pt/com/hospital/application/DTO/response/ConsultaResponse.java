package pt.com.hospital.application.DTO.response;

import java.time.LocalDateTime;

public class ConsultaResponse {
    public Long id;
    public long pacienteId;
    public long medicoId;
    public String status;
    public LocalDateTime dataHora;
    public LocalDateTime dataCadastro;
    private String motivoConsulta;

    public ConsultaResponse(){}


    public ConsultaResponse(Long id, long pacienteId, long medicoId, String status, LocalDateTime dataHora,
                            LocalDateTime dataCadastro, String motivoConsulta) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.status = status;
        this.dataHora = dataHora;
        this.dataCadastro = dataCadastro;
        this.motivoConsulta = motivoConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long  getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(long medicoId) {
        this.medicoId = medicoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
}
