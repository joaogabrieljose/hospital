package pt.com.hospital.DTO.mapper;

import pt.com.hospital.DTO.request.MedicoRequest;
import pt.com.hospital.DTO.response.MedicoResponse;
import pt.com.hospital.domain.entity.Medico;

public class MedicoMapper {

    public static Medico toMedico(MedicoRequest request){
        Medico medico = new Medico();
        medico.setId(request.getId());
        medico.setName(request.getName());
        medico.setEmail(request.getEmail());
        medico.setEndereco(request.getEndereco());
        medico.setTelefone(request.getTelefone());
        medico.setEspecialidade(request.getEspecialidade());
        medico.setConsulta(request.getConsulta());
        medico.setDataCadastro(request.getDataCadastro());

        return medico;
    }

    public static MedicoResponse toMedicoResponse(Medico medico){

        MedicoResponse medicoResponse = new MedicoResponse();
        medicoResponse.setId(medico.getId());
        medicoResponse.setName(medico.getName());
        medicoResponse.setEmail(medico.getEmail());
        medicoResponse.setEndereco(medico.getEndereco());
        medicoResponse.setTelefone(medico.getTelefone());
        medicoResponse.setEspecialidade(medico.getEspecialidade());
        medicoResponse.setConsulta(medico.getConsulta());
        medicoResponse.setDataCadastro(medico.getDataCadastro());
        return  medicoResponse;
    }
}
