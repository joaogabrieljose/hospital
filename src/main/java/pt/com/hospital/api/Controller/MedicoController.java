package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.request.MedicoRequest;
import pt.com.hospital.application.DTO.response.MedicoResponse;
import pt.com.hospital.domain.Service.MedicoService;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping("/medico/")
    public ResponseEntity<MedicoResponse> create(@RequestBody MedicoRequest request){
        var create = service.create(request);
        return ResponseEntity.ok(create);
    }
    @GetMapping("/medico/{id}")
    public ResponseEntity<MedicoResponse> getMedicoById(@PathVariable long id, MedicoRequest request){
        var get = service.getMedicoById(id);
        return  ResponseEntity.ok(get);
    }

    @GetMapping("/medico/")
    public ResponseEntity<List<MedicoResponse>> findAll(){
        var findAllMedico = service.findAll();
        return ResponseEntity.ok(findAllMedico);
    }

    @PutMapping("/medico/{id}")
    public ResponseEntity<MedicoResponse> updateMedico(@PathVariable long id, @RequestBody MedicoRequest request) {
        MedicoResponse updateMedico = service.updateMedico(id, request);
        return ResponseEntity.ok(updateMedico);
    }


    @DeleteMapping("/medico/{id}")
    public ResponseEntity<Void> deleteMedicoById(@PathVariable long id){
        boolean sucesso = service.deleteMedicoById(id);
        if (sucesso){
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
