package com.exemple.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exemple.model.Movimentacao;
import com.exemple.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
@CrossOrigin("*")
public class MovitacaoController {
	@Autowired
	private MovimentacaoService service;

	
	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> GetById(@PathVariable Integer id) { // variavel presentena uri eww
		Movimentacao obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Movimentacao>> GetAll() {
		List<Movimentacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Movimentacao> Post(@RequestBody Movimentacao usuario) {
		Movimentacao newObj = service.create(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.status(HttpStatus.GONE).body(service.create(usuario));
		// return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movimentacao> Put(@PathVariable Integer id, @RequestBody Movimentacao obj) {
		Movimentacao newUsuario = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUsuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
