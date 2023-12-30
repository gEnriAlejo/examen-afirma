package com.afirma.apiexamenafirma.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afirma.apiexamenafirma.repository.entity.Cliente;
import com.afirma.apiexamenafirma.service.IClienteService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> consultarTodos() {	
	
		List<Cliente> clientes = new ArrayList<>();
		
		clientes = this.service.consultarTodos();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Long> crea(@Valid @RequestBody Cliente cliente) {
		
		Long idCliente = this.service.crear(cliente);
		return new ResponseEntity<>(idCliente, HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> modifica(@Valid @RequestBody Cliente cliente) {
		
		this.service.actualizar(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> elimina(
				@PathVariable(value = "id", required = true) long id ) {
		
		this.service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);		
		
	}
	
}
