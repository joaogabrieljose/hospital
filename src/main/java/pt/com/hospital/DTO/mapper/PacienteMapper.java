package pt.com.hospital.DTO.mapper;

import pt.com.hospital.DTO.request.PacienteRequest;
import pt.com.hospital.DTO.response.PacienteResponse;
import pt.com.hospital.domain.entity.Paciente;

public class PacienteMapper {

    public static Paciente toPaciente(PacienteRequest request){
        Paciente paciente = new Paciente();

        paciente.setId(request.getId());
        paciente.setName(request.getName());
        paciente.setEmail(request.getEmail());
        paciente.setSexo(request.getSexo());
        paciente.setTelefone(request.getTelefone());
        paciente.setConsulta(request.getConsulta());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setDataCadastro(request.getDataCadastro());
        return  paciente;
    }

    public static PacienteResponse toPacienteResponse(Paciente paciente){
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setName(paciente.getName());
        pacienteResponse.setEmail(paciente.getEmail());
        pacienteResponse.setSexo(paciente.getSexo());
        pacienteResponse.setTelefone(paciente.getTelefone());
        pacienteResponse.setConsulta(paciente.getConsulta());
        pacienteResponse.setDataNascimento(paciente.getDataNascimento());
        pacienteResponse.setDataCadastro(paciente.getDataCadastro());
        return  pacienteResponse;
    }
}
