package com.farmacia.farmacia.controller;
 
import java.util.List;

import javax.validation.Valid;

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
import com.farmacia.farmacia.model.Categoria;
import com.farmacia.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping ("/Categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repository.findAll());	
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById (@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());	
	}
	
	@GetMapping("/exame/{exame}")
	public ResponseEntity<List<Categoria>> GetByExame (@PathVariable String exame){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByExameContainingIgnoreCase(exame));
	}
	@PostMapping("/criar")
	public ResponseEntity<Categoria> saveCategoria (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<Categoria> updateCategoria (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	

}
