package io.github.danilochaves.msproposta.services;


import io.github.danilochaves.msproposta.dto.PropostaRequestDto;
import io.github.danilochaves.msproposta.dto.PropostaResponseDto;
import io.github.danilochaves.msproposta.mapper.PropostaMapper;
import io.github.danilochaves.msproposta.models.Proposta;
import io.github.danilochaves.msproposta.repositories.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropostaService {
    
    private final PropostaRepository repository;

    public PropostaResponseDto insert(PropostaRequestDto propostaRequestDto) {
        Proposta propostaEntity = PropostaMapper.INSTANCE.mapDtoToEntity(propostaRequestDto);
        repository.save(propostaEntity);
        return PropostaMapper.INSTANCE.mapEntityToDto(propostaEntity);
    }
}
