package com.example.algamoney.api.service.lancamento;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.exception.PessoaInexistenteOuInativaException;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.lancamento.LancamentoRepository;
import com.example.algamoney.api.repository.lancamento.filter.LancamentoFilter;
import com.example.algamoney.api.repository.lancamento.projection.ResumoLancamento;
import com.example.algamoney.api.service.pessoa.PessoaService;

@Service("lancamentoService")
public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Override
	public Lancamento criar(Lancamento lancamento) {		
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public Page<Lancamento> listar(LancamentoFilter lancamentoFilter, Pageable pageable) {		
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}

	@Override
	public Page<ResumoLancamento> resumo(LancamentoFilter lancamentoFilter, Pageable pageable) {		
		return lancamentoRepository.resumir(lancamentoFilter, pageable);
	}

	@Override
	public Lancamento buscarPeloCodigo(long codigo) {		
		return lancamentoRepository.findOne(codigo);
	}

	@Override
	public void remover(long codigo) {
		lancamentoRepository.delete(codigo);		
	}

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaService.buscarPeloCodigo(lancamento.getPessoa().getCodigo());
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}

		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);
		if(!lancamento.getPessoa().equals(lancamento.getPessoa())) {
			pessoaService.validarPessoa(lancamento.getPessoa());
		}
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		
		return lancamentoRepository.save(lancamentoSalvo);
	}

	private Lancamento buscarLancamentoExistente(Long codigo) {
		Lancamento lancamentoSalvo = lancamentoRepository.findOne(codigo);
		if (lancamentoSalvo == null) {
			throw new IllegalArgumentException();
		}
		return lancamentoSalvo;
	}	
	
}
