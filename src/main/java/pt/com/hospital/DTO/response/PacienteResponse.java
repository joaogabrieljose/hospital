package pt.com.hospital.DTO.response;

import pt.com.hospital.domain.entity.Consulta;

import java.util.Date;
import java.util.List;

public class PacienteResponse {
    public long id;
    public String name;
    public Date dataNascimento;
    public  String sexo;
    public String telefone;
    public String email;
    public Date dataCadastro;
    public List<Consulta> consulta;

    public PacienteResponse(){}

    public PacienteResponse(long id, String name, Date dataNascimento, String sexo, String telefone,
                           String email, Date dataCadastro, List<Consulta> consulta) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.consulta = consulta;
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

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
}
