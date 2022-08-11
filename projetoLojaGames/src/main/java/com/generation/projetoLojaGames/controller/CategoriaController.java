package com.generation.projetoLojaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.projetoLojaGames.model.CategoriaModel;
import com.generation.projetoLojaGames.repository.CategoriaRepository;



@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")

public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById (@PathVariable Long id){
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeCategoria/{nomeCategoria}")
	public ResponseEntity<List<CategoriaModel>> GetByNomeCategoria(@PathVariable String nomeCategoria){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel categoriaModel){
	return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoriaModel));
	}	
	
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel categoriaModel){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoriaModel));
	}
	
	@DeleteMapping
	
	public void delete (@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
}
