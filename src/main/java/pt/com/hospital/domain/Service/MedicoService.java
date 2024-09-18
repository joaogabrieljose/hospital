package pt.com.hospital.domain.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.hospital.application.DTO.mapper.MedicoMapper;
import pt.com.hospital.application.DTO.request.MedicoRequest;
import pt.com.hospital.application.DTO.response.MedicoResponse;
import pt.com.hospital.domain.entity.Medico;
import pt.com.hospital.domain.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    //cria medico
    public MedicoResponse create (MedicoRequest request){
        var medico = MedicoMapper.toMedico(request);
        var create = repository.save(medico);
        return MedicoMapper.toMedicoResponse(create);
    }

    public MedicoResponse getMedicoById(long id){
        Optional<Medico> medico = repository.findMedicoById(id);
        Medico get = medico.orElseThrow(()-> new RuntimeException("medico não encontrado"));
        return MedicoMapper.toMedicoResponse(get);
    }

    public List<MedicoResponse> findAll(){
        List<Medico> medico  = (List<Medico>) repository.findAll();
        List<MedicoResponse> findMedico = medico.stream()
                .map(MedicoMapper::toMedicoResponse).toList();

        return  findMedico;
    }

    public MedicoResponse updateMedico(long id, MedicoRequest medicoAtualizado) {
        Optional<Medico> medico = repository.findMedicoById(id);

        Medico medicoExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com id: " + id));

        medicoExistente.setName(medicoAtualizado.getName());
        medicoExistente.setEspecialidade(medicoAtualizado.getEspecialidade());
        medicoExistente.setTelefone(medicoAtualizado.getTelefone());
        medicoExistente.setEmail(medicoAtualizado.getEmail());
        medicoExistente.setEndereco(medicoAtualizado.getEndereco());
        medicoExistente.setDataCadastro(medicoAtualizado.getDataCadastro());

        Medico update = repository.save(medicoExistente);
        return MedicoMapper.toMedicoResponse(update);
    }

    public boolean deleteMedicoById(long id){
      Optional<Medico> medico = repository.findMedicoById(id);
      if (medico.isPresent()){
          repository.deleteById(id);
          return  true;
      }
      return false;
    }
}
