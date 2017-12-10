package com.example.algamoney.api.repository.permissao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>, PermissaoRepositoryQuery {
	
}
