package io.github.danilochaves.msproposta.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_proposta")
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    @JsonManagedReference
    private Usuario usuario;
}