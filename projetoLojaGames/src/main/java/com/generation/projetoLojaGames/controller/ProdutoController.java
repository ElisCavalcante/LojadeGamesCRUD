package com.generation.projetoLojaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.projetoLojaGames.model.ProdutoModel;
import com.generation.projetoLojaGames.repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll (){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/id")
	
	public ResponseEntity<ProdutoModel> getById (@PathVariable Long id){
		return produtoRepository.findById(id).
				map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeProduto/{nomeProduto}")
	
	public ResponseEntity<List<ProdutoModel>> getByNomeProduto (@PathVariable String nomeProduto){
		return ResponseEntity.ok(produtoRepository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel produtoModel){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtoModel));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@RequestBody ProdutoModel produtoModel){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save (produtoModel));
	}
}