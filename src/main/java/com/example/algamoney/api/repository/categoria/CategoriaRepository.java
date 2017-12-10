package com.example.algamoney.api.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, CategoriaRepositoryQuery {

}
