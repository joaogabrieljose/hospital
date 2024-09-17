package pt.com.hospital.application.DTO.mapper;

import pt.com.hospital.application.DTO.request.ConsultaRequest;
import pt.com.hospital.application.DTO.response.ConsultaResponse;
import pt.com.hospital.domain.entity.Consulta;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.entity.Paciente;

public class ConsultaMapper {

    public static Consulta toConsulta(ConsultaRequest request) {
        Consulta consulta = new Consulta();

        Medico medico = new Medico();
        medico.setId(request.getMedicoId());
        consulta.setMedico(medico);

        Paciente paciente = new Paciente();
        paciente.setId(request.getPacienteId());
        consulta.setPaciente(paciente);

        consulta.setDataHora(request.getDataHora());
        consulta.setDataCadastro(request.getDataCadastro());

        return consulta;
    }

    public static ConsultaResponse toConsultaResponse(Consulta consulta) {
        ConsultaResponse consultaResponse = new ConsultaResponse();

        consultaResponse.setId(consulta.getId());
        consultaResponse.setMedicoId(consulta.getMedico().getId()); // Retorna o ID do médico
        consultaResponse.setPacienteId(consulta.getPaciente().getId()); // Retorna o ID do paciente

        consultaResponse.setDataHora(consulta.getDataHora());
        consultaResponse.setStatus(consulta.getStatus());
        consultaResponse.setDataCadastro(consulta.getDataCadastro());

        return consultaResponse;
    }
}
