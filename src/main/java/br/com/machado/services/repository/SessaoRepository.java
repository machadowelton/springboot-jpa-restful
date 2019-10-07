package br.com.machado.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.machado.models.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
