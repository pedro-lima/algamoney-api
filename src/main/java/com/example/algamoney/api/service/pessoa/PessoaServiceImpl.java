package com.example.algamoney.api.service.pessoa;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.exception.PessoaInexistenteOuInativaException;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.pessoa.PessoaRepository;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
		
	@Override
	public List<Pessoa> listar() {		
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa criar(Pessoa pessoa) {		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa buscarPeloCodigo(Long codigo) {		
		return pessoaRepository.findOne(codigo);
	}

	@Override
	public void remover(Long codigo) {
		pessoaRepository.delete(codigo);		
	}

	@Override
	public Page<Pessoa> pesquisar(String nome, Pageable pageable) {		
		return pessoaRepository.findByNomeContaining(nome, pageable);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}

	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	public void validarPessoa(Pessoa pessoa) {
		Pessoa pessoaTemp = null;
		if (pessoa != null && pessoa.getCodigo() != null) {
			pessoa = pessoaRepository.findOne(pessoa.getCodigo());
		}

		if (pessoaTemp == null || pessoaTemp.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
	}
	
}
