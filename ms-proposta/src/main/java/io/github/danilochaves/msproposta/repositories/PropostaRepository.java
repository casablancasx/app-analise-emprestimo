package io.github.danilochaves.msproposta.repositories;


import io.github.danilochaves.msproposta.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {
    List<Proposta> findAllByIntegradaIsFalse();
}
