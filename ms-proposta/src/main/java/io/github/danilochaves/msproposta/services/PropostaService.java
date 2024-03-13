package io.github.danilochaves.msproposta.services;


import io.github.danilochaves.msproposta.dto.PropostaRequestDto;
import io.github.danilochaves.msproposta.dto.PropostaResponseDto;
import io.github.danilochaves.msproposta.mapper.PropostaMapper;
import io.github.danilochaves.msproposta.models.Proposta;
import io.github.danilochaves.msproposta.repositories.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropostaService {
    
    private final PropostaRepository repository;
    private final NotificarRabbitService notificarRabbitService;

    public PropostaResponseDto insert(PropostaRequestDto propostaRequestDto) {
        Proposta propostaEntity = PropostaMapper.INSTANCE.mapDtoToEntity(propostaRequestDto);
        repository.save(propostaEntity);
        notificarRabbitMQ(propostaEntity);
        return PropostaMapper.INSTANCE.mapEntityToDto(propostaEntity);
    }

    public List<PropostaResponseDto> findAll() {
        List<Proposta> listEntity = repository.findAll();
        return PropostaMapper.INSTANCE.mapListEntityToListDto(listEntity);
    }

    public void notificarRabbitMQ(Proposta proposta){
        try {
            notificarRabbitService.notificar(proposta);
        }catch (RuntimeException ex){
            proposta.setIntegrada(false);
            repository.save(proposta);
        }
    }
}
