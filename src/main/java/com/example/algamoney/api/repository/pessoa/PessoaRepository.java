package com.example.algamoney.api.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {
	
	public Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);

}
