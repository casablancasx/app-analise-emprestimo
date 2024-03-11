package io.github.danilochaves.msproposta.controllers;


import io.github.danilochaves.msproposta.dto.PropostaRequestDto;
import io.github.danilochaves.msproposta.dto.PropostaResponseDto;
import io.github.danilochaves.msproposta.services.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/proposta")
@AllArgsConstructor
public class PropostaController {

    private final PropostaService service;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> insert(@RequestBody PropostaRequestDto propostaRequestDto){
        PropostaResponseDto response = service.insert(propostaRequestDto);
        return ResponseEntity.created(URI.create("/proposta/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> findAllProposta(){
        List<PropostaResponseDto> responseList = service.findAll();
        return ResponseEntity.ok(responseList);
    }
}
