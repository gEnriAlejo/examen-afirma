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

import com.afirma.apiexamenafirma.repository.entity.Reserva;
import com.afirma.apiexamenafirma.service.IReservaService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping(path = "/reserva")
public class ReservaController {
	
	@Autowired
	private IReservaService service;
	
	@GetMapping
	public ResponseEntity<List<Reserva>> consultarTodos() {	
	
		List<Reserva> reservas = new ArrayList<>();
		
		reservas = this.service.consultarTodos();
		return new ResponseEntity<>(reservas, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Long> crea(@Valid @RequestBody Reserva reserva) {
		
		Long idReserva = this.service.crear(reserva);
		return new ResponseEntity<>(idReserva, HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> modifica(@Valid @RequestBody Reserva reserva) {
		
		this.service.actualizar(reserva);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> elimina(
						@PathVariable(value = "id", required = true) int id ) {
		
		this.service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);		
		
	}
	
}