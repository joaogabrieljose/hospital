package pt.com.hospital.DTO.mapper;

import pt.com.hospital.DTO.request.ConsultaRequest;
import pt.com.hospital.DTO.response.ConsultaResponse;
import pt.com.hospital.domain.entity.Consulta;

public class ConsultaMapper {

    public static Consulta toConsulta(ConsultaRequest request){
        Consulta consulta = new Consulta();
        if(request.getId() != null){
            consulta.setId(request.getId());
        }
        consulta.setStatus(request.getStatus());
        consulta.setMedico(request.getMedico());
        consulta.setPaciente(request.getPaciente());
        consulta.setMotivoConsulta(request.getMotivoConsulta());
        consulta.setDataHora(request.getDataHora());
        consulta.setDataCadastro(request.getDataCadastro());
        return  consulta;
    }

    public ConsultaResponse toConsultaResponse(Consulta consulta){
        ConsultaResponse consultaResponse = new ConsultaResponse();
        if(consulta.getId() != null){
            consultaResponse.setId(consulta.getId());
        }
        consultaResponse.setStatus(consulta.getStatus());
        consultaResponse.setMedico(consulta.getMedico());
        consultaResponse.setPaciente(consulta.getPaciente());
        consultaResponse.setMotivoConsulta(consulta.getMotivoConsulta());
        consultaResponse.setDataHora(consulta.getDataHora());
        consultaResponse.setDataCadastro(consulta.getDataCadastro());
        return  consultaResponse;
    }
}
