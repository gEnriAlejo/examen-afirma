package com.afirma.apiexamenafirma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirma.apiexamenafirma.repository.ClienteRepository;
import com.afirma.apiexamenafirma.repository.entity.Cliente;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public long crear(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getIdCliente();
	}

	@Override
	public List<Cliente> consultarTodos() {
		List<Cliente> ctes = clienteRepository.findAll();
		return ctes;
	}

	@Override
	public void actualizar(Cliente cliente) {
		Optional<Cliente> optCliente = clienteRepository.findById(cliente.getIdCliente());
		
		if(optCliente.isPresent()) {
			// Metodo save() de Spring Data Jpa identifica si es un alta o una modificación
			clienteRepository.save(cliente);			
		}
	}

	@Override
	public void eliminar(long id) {
		clienteRepository.deleteById(id);
	}

}
