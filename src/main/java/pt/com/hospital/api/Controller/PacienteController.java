package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.com.hospital.application.DTO.mapper.PacienteMapper;
import pt.com.hospital.application.DTO.request.PacienteRequest;
import pt.com.hospital.application.DTO.response.PacienteResponse;
import pt.com.hospital.domain.Service.PacienteService;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping("/paciente/")
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest request){
        var create = PacienteMapper.toPaciente(request);
        var novoCreatos = service.createPaciente(create);
        var response = PacienteMapper.toPacienteResponse(novoCreatos);
        return ResponseEntity.ok(response);
    }




}
