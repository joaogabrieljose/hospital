package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.mapper.MedicoMapper;
import pt.com.hospital.application.DTO.request.MedicoRequest;
import pt.com.hospital.application.DTO.response.MedicoResponse;
import pt.com.hospital.domain.Service.MedicoService;
import pt.com.hospital.domain.entity.Medico;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping("/medico/")
    public ResponseEntity<MedicoResponse> create(@RequestBody MedicoRequest request){
        var create = MedicoMapper.toMedico(request);
        var newCreate = service.create(create);
        MedicoResponse novo = MedicoMapper.toMedicoResponse(newCreate);
        return  ResponseEntity.ok(novo);
    }
    @GetMapping("/medico/{id}")
    public ResponseEntity<MedicoResponse> getMedicoById(@PathVariable long id, MedicoRequest request){
        var getMedico = MedicoMapper.toMedico(request);
        var get = service.getMedicoById(id);
        MedicoResponse getMedicoById = MedicoMapper.toMedicoResponse(get);
        return  ResponseEntity.ok(getMedicoById);
    }

    @GetMapping("/medico/")
    public ResponseEntity<List<MedicoResponse>> findAll(){
        List<Medico> novoLista = service.findAll();
        List<MedicoResponse> novo = novoLista.stream().map(MedicoMapper::toMedicoResponse).toList();
        return ResponseEntity.ok(novo);
    }

    @PutMapping("/medico/{id}")
    public ResponseEntity<MedicoResponse> updateMedico(@PathVariable long id, MedicoRequest request){
        var update = MedicoMapper.toMedico(request);
        var newUpdate = service.update(id,update);
        MedicoResponse novo = MedicoMapper.toMedicoResponse(newUpdate);
        return  ResponseEntity.ok(novo);
    }

    @DeleteMapping("/medio/{id}")
    public ResponseEntity<MedicoResponse> deleteById(@PathVariable long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
