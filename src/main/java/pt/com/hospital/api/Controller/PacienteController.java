package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.request.PacienteRequest;
import pt.com.hospital.application.DTO.response.PacienteResponse;
import pt.com.hospital.domain.Service.PacienteService;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping("/paciente/")
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest request) {
        var create = service.createPaciente(request);
        return ResponseEntity.ok(create);
    }

    @GetMapping("/paciente/")
    public ResponseEntity<List<PacienteResponse>> findAll() {
        var findPaciente = service.findAll();
        return ResponseEntity.ok(findPaciente);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> getPacienteById(@PathVariable long id) {
        var get = service.getPacienteById(id);
        return ResponseEntity.ok(get);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> update(@PathVariable long id, @RequestBody PacienteRequest request) {
        var updatedById = service.updateById(id, request);
        return new ResponseEntity<>(updatedById, HttpStatus.OK);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){

        Boolean sucesso  = service.deleteById(id);
        if (sucesso){
            service.deleteById(id);
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
