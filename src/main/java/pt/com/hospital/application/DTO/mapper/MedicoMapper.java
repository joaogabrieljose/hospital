package pt.com.hospital.application.DTO.mapper;

import pt.com.hospital.application.DTO.request.MedicoRequest;
import pt.com.hospital.application.DTO.response.MedicoResponse;
import pt.com.hospital.domain.entity.Medico;

public class MedicoMapper {

    public static Medico toMedico(MedicoRequest request) {
        Medico medico = new Medico();
        medico.setName(request.getName());
        medico.setEspecialidade(request.getEspecialidade());
        medico.setTelefone(request.getTelefone());
        medico.setEmail(request.getEmail());
        medico.setEndereco(request.getEndereco());
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
        medicoResponse.setDataCadastro(medico.getDataCadastro());
        return  medicoResponse;
    }
}
