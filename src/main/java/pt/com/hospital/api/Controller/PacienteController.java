package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.mapper.PacienteMapper;
import pt.com.hospital.application.DTO.request.PacienteRequest;
import pt.com.hospital.application.DTO.response.PacienteResponse;
import pt.com.hospital.domain.Service.PacienteService;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping("/paciente/")
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest request){
        var create = service.createPaciente(request);
        return ResponseEntity.ok(create);
    }

    @GetMapping("/paciente/")
    public  ResponseEntity<List<PacienteResponse>> findAll(){
       var findPaciente = service.findAll();
        return  ResponseEntity.ok(findPaciente);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> getPacienteById(@PathVariable long id, PacienteRequest request){
        var create = PacienteMapper.toPaciente(request);
        var getNovo = service.getPacienteById(id);
        PacienteResponse getPaciente = PacienteMapper.toPacienteResponse(getNovo);
        return  ResponseEntity.ok(getPaciente);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> update(@PathVariable long id,@RequestBody PacienteRequest request){
        var update = PacienteMapper.toPaciente(request);
        var newUpadte = service.updateById(id, update);
        PacienteResponse updatePaciente = PacienteMapper.toPacienteResponse(newUpadte);
        return new ResponseEntity<>(updatePaciente, HttpStatus.OK);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
