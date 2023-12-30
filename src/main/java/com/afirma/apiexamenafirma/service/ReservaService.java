package com.afirma.apiexamenafirma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirma.apiexamenafirma.repository.ReservaRepository;
import com.afirma.apiexamenafirma.repository.entity.Reserva;

@Service
public class ReservaService implements IReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public long crear(Reserva reserva) {
		reservaRepository.save(reserva);
		return reserva.getIdReserva();
	}

	@Override
	public List<Reserva> consultarTodos() {
		return reservaRepository.findAll();
	}

	@Override
	public void actualizar(Reserva reserva) {
		Optional<Reserva> optReserva = reservaRepository.findById(reserva.getIdReserva());
		
		if(optReserva.isPresent()) {
			// Metodo save() de Spring Data Jpa identifica si es un alta o una modificación
			reservaRepository.save(reserva);			
		}

	}

	@Override
	public void eliminar(long id) {
		reservaRepository.deleteById(id);
	}

}
