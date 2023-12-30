package com.afirma.apiexamenafirma.service;

import java.util.List;

import com.afirma.apiexamenafirma.repository.entity.Cliente;

public interface IClienteService {
	
	long crear(Cliente cliente);
	List<Cliente> consultarTodos();
	void actualizar(Cliente cliente);
	void eliminar(long id);

}
