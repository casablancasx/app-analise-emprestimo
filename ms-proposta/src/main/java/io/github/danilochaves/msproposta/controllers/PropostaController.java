package io.github.danilochaves.msproposta.controllers;


import io.github.danilochaves.msproposta.dto.PropostaRequestDto;
import io.github.danilochaves.msproposta.dto.PropostaResponseDto;
import io.github.danilochaves.msproposta.services.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
@AllArgsConstructor
public class PropostaController {

    private final PropostaService service;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> insert(@RequestBody PropostaRequestDto propostaRequestDto){
        PropostaResponseDto response = service.insert(propostaRequestDto);
        return ResponseEntity.ok(response);
    }
}
