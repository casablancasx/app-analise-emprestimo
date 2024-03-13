package io.github.danilochaves.msproposta.mapper;

import io.github.danilochaves.msproposta.dto.PropostaRequestDto;
import io.github.danilochaves.msproposta.dto.PropostaResponseDto;
import io.github.danilochaves.msproposta.models.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(source = "nome", target = "usuario.nome")
    @Mapping(source = "sobrenome", target = "usuario.sobrenome")
    @Mapping(source = "telefone", target = "usuario.telefone")
    @Mapping(source = "cpf", target = "usuario.cpf")
    @Mapping(source = "renda", target = "usuario.renda")
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "aprovada",ignore = true)
    @Mapping(target = "integrada",constant = "true")
    @Mapping(target = "observacao",ignore = true)
    Proposta mapDtoToEntity(PropostaRequestDto requestDto);

    @Mapping(source = "usuario.nome" , target = "nome")
    @Mapping(source = "usuario.sobrenome" , target = "sobrenome")
    @Mapping(source = "usuario.telefone" , target = "telefone")
    @Mapping(source = "usuario.cpf" , target = "cpf")
    @Mapping(source = "usuario.renda" , target = "renda")
    @Mapping(target = "valorSolicitadoFmt" , expression = "java(setValorSolicicitadoFmt(proposta))")
    PropostaResponseDto mapEntityToDto(Proposta proposta);

    List<PropostaResponseDto> mapListEntityToListDto(Iterable<Proposta> listEntity);

    default String setValorSolicicitadoFmt(Proposta proposta){
        return NumberFormat.getCurrencyInstance().format(proposta.getValorSolicitado());
    }
}