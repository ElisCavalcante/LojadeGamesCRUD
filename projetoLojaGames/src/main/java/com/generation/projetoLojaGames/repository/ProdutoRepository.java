package com.generation.projetoLojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projetoLojaGames.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	public List<ProdutoModel>findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
	
}
