package com.afirma.apiexamenafirma.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.afirma.apiexamenafirma.repository.entity.Cliente;
import com.afirma.apiexamenafirma.service.IClienteService;

@SpringBootTest
@ContextConfiguration(classes = ClienteController.class)
public class ClienteControllerTest {
	
	private static Cliente cliente;
	
    @Autowired
    private ClienteController clienteController;
    @MockBean
    private IClienteService clienteService;
    
    @BeforeAll
    static void beforeAll() {
    	cliente = new Cliente();
    }

    @Test
    public void consultarTodos_whenConsultaIsOK_return200() {
        ResponseEntity<List<Cliente>> response = clienteController.consultarTodos();
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void consultarTodos_whenCreaIsOK_return201() {
        ResponseEntity<Long> response = clienteController.crea(cliente);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void consultarTodos_whenModificaIsOK_return200() {
        ResponseEntity<Void> response = clienteController.modifica(cliente);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void consultarTodos_whenEliminaIsOK_return200() {
        ResponseEntity<Void> response = clienteController.elimina(1);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

}
