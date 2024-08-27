package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.mapper.PacienteMapper;
import pt.com.hospital.application.DTO.request.PacienteRequest;
import pt.com.hospital.application.DTO.response.PacienteResponse;
import pt.com.hospital.domain.Service.PacienteService;
import pt.com.hospital.domain.entity.Paciente;

import java.util.List;

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

    @GetMapping("/paciente/")
    public  ResponseEntity<List<PacienteResponse>> findAll(){
        List<Paciente> listPaciente = service.findAll();
        List<PacienteResponse> novo = listPaciente.stream()
                .map(PacienteMapper:: toPacienteResponse).toList();
        return  ResponseEntity.ok(novo);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> getPacienteById(@PathVariable long id, PacienteRequest request){
        var create = PacienteMapper.toPaciente(request);
        var getNovo = service.getPacienteById(id);
        PacienteResponse getPaciente = PacienteMapper.toPacienteResponse(getNovo);
        return  ResponseEntity.ok(getPaciente);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> updatePacienteById(@PathVariable long id, PacienteRequest request){
        var update = PacienteMapper.toPaciente(request);
        var newUpadte = service.updateById(id, update);
        PacienteResponse updatePaciente = PacienteMapper.toPacienteResponse(newUpadte);
        return  ResponseEntity.ok(updatePaciente);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
