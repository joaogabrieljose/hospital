package pt.com.hospital.DTO.request;

import pt.com.hospital.domain.entity.Consulta;

import java.util.Date;
import java.util.List;

public class MedicoRequest {
    public long id;
    public String name;
    public String especialidade;
    public String telefone;
    public String email;
    public String endereco;
    public Date dataCadastro;
    public List<Consulta> consulta;

    public MedicoRequest(){}

    public MedicoRequest(long id, String name, String especialidade, String telefone, String email, String
            endereco, Date dataCadastro, List<Consulta> consulta) {
        this.id = id;
        this.name = name;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
