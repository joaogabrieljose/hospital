package pt.com.hospital.application.DTO.request;

import java.time.LocalDateTime;

public class ConsultaRequest {
    public long pacienteId ;
    public long medicoId;
    public LocalDateTime dataHora;
    public LocalDateTime dataCadastro;

    public ConsultaRequest(){}

    public ConsultaRequest(long pacienteId, long medicoId, LocalDateTime dataHora, LocalDateTime dataCadastro) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.dataHora = dataHora;
        this.dataCadastro = dataCadastro;
    }

    public long getPacienteId() {
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
}
