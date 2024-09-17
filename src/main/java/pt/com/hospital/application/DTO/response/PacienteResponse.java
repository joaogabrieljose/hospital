package pt.com.hospital.application.DTO.response;

import java.util.Date;

public class PacienteResponse {
    public long id;
    public String name;
    public Date dataNascimento;
    public  String sexo;
    public String telefone;
    public String email;
    public Date dataCadastro;
    public long  consultaId;

    public PacienteResponse(){}

    public PacienteResponse(long id, String name, Date dataNascimento, String sexo, String telefone,
                           String email, Date dataCadastro, long consultaId) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.consultaId = consultaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(long consultaId) {
        this.consultaId = consultaId;
    }
}
