package com.example.algamoney.api.service.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.lancamento.filter.LancamentoFilter;
import com.example.algamoney.api.repository.lancamento.projection.ResumoLancamento;

public interface LancamentoService {

	Lancamento criar(Lancamento lancamento);

	Lancamento atualizar(Long codigo, Lancamento lancamento);

	Page<Lancamento> listar(LancamentoFilter lancamentoFilter, Pageable pageable);

	Page<ResumoLancamento> resumo(LancamentoFilter lancamentoFilter, Pageable pageable);

	Lancamento buscarPeloCodigo(long codigo);

	void remover(long codigo);

}
