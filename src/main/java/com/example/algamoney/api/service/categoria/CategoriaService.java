package com.example.algamoney.api.service.categoria;

import java.util.List;

import com.example.algamoney.api.model.Categoria;

public interface CategoriaService {

	List<Categoria> listar();

	Categoria criar(Categoria categoria);

	Categoria buscarPeloCodigo(long codigo);

}
