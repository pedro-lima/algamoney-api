package com.example.algamoney.api.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.categoria.CategoriaRepository;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> listar() {		
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria criar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria buscarPeloCodigo(long codigo) {
		return categoriaRepository.findOne(codigo);
	}	

}
