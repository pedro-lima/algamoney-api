package com.example.algamoney.api.repository.lancamento;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
