package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.request.ConsultaRequest;
import pt.com.hospital.application.DTO.response.ConsultaResponse;
import pt.com.hospital.domain.Service.ConsultaService;

import java.util.List;

@RestController
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/consulta/") // agendar consulta
    public ResponseEntity<ConsultaResponse> save(@RequestBody ConsultaRequest request) {
        var createConsulta = service.create(request);
        return ResponseEntity.ok(createConsulta);
    }

    @GetMapping("/consulta/") // lista todas as consultas
    public ResponseEntity<List<ConsultaResponse>> findAll() {
        var findAllConsulta = service.findAll();
        return ResponseEntity.ok(findAllConsulta);
    }

    @PutMapping("/consulta/{id}")
    public ResponseEntity<ConsultaResponse> updateStatusConsulta(@PathVariable long id, @RequestBody ConsultaRequest request) {
        var update = service.updateConsulta(id, request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/consulta/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {

        boolean sucesso = service.cancelaConsulta(id);
        if (sucesso) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
