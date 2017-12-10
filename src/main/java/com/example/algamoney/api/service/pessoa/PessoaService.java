package com.example.algamoney.api.service.pessoa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.algamoney.api.model.Pessoa;

public interface PessoaService {

	List<Pessoa> listar();

	Pessoa criar(Pessoa pessoa);

	Pessoa buscarPeloCodigo(Long codigo);

	void remover(Long codigo);

	Pessoa atualizar(Long codigo, Pessoa pessoa);

	void atualizarPropriedadeAtivo(Long codigo, Boolean ativo);

	Page<Pessoa> pesquisar(String nome, Pageable pageable);

	void validarPessoa(Pessoa pessoa);

}
