package pt.com.hospital.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.hospital.application.DTO.mapper.ConsultaMapper;
import pt.com.hospital.application.DTO.request.ConsultaRequest;
import pt.com.hospital.application.DTO.response.ConsultaResponse;
import pt.com.hospital.domain.Service.ConsultaService;
import pt.com.hospital.domain.entity.Consulta;

import java.util.List;

@RestController
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/consulta/") // agendar consulta
    public ResponseEntity<ConsultaResponse> save(@RequestBody ConsultaRequest request) {
        var consulta = ConsultaMapper.toConsulta(request);
        var consultaAgendada = service.agendaConsulta(consulta);
        var response = ConsultaMapper.toConsultaResponse(consultaAgendada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/consulta") // lista todas as consultas
    public ResponseEntity<List<ConsultaResponse>> findAll(){
        List<Consulta> crateLista = service.findAll();
        List<ConsultaResponse> responseList = crateLista.stream().map(ConsultaMapper:: toConsultaResponse).toList();
        return  ResponseEntity.ok(responseList);
    }
/*
    @PutMapping("/consulta/{id}")
    public ResponseEntity<ConsultaResponse> updateConsulta(
            @PathVariable long id, @RequestBody ConsultaRequest request) {

        Consulta consultaExistente = service.updateConsulta(id)
                .orElseThrow(() -> new NoSuchElementException("Consulta não encontrada com id: " + id));

        consultaExistente.setDataHora(request.getDataHora());
        consultaExistente.setMotivoConsulta(request.getMotivoConsulta());
        consultaExistente.setStatus(request.getStatus());
        Consulta consultaAtualizada = service.updateConsulta(consultaExistente);
        ConsultaResponse response = ConsultaMapper.toConsultaResponse(consultaAtualizada);
        return ResponseEntity.ok(response);
    }*/

    @DeleteMapping("/consulta/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        service.cancelaConsulta(id);
        return ResponseEntity.ok().build();
    }

}
