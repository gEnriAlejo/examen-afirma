package com.afirma.apiexamenafirma.service;

import java.util.List;

import com.afirma.apiexamenafirma.repository.entity.Reserva;

public interface IReservaService {
	
	long crear(Reserva reserva);
	List<Reserva> consultarTodos();
	void actualizar(Reserva reserva);
	void eliminar(long id);

}
