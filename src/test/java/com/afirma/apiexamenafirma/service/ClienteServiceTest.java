package com.afirma.apiexamenafirma.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.afirma.apiexamenafirma.repository.ClienteRepository;
import com.afirma.apiexamenafirma.repository.entity.Cliente;

@SpringBootTest
@ContextConfiguration(classes = ClienteService.class)
public class ClienteServiceTest {
	
    private static List<Cliente> clientes;
    private static Cliente cliente;
	
    @Autowired
    private ClienteService clienteService;
    @MockBean
    private ClienteRepository clienteRepository;
    
    @BeforeAll
    static void beforeAll() {
    	cliente = Cliente
    			.builder()
    			.idCliente(1)
    			.build();
    	clientes = List.of(new Cliente(), new Cliente());
    }
    
    @Test
    public void consultarTodos_happyPath_ReturnList() {
        Mockito.when( clienteRepository.findAll() ).thenReturn(clientes);
        List<Cliente> clientes = clienteService.consultarTodos();
        Assertions.assertNotNull(clientes);
        Assertions.assertEquals(2, clientes.size());
    }
    
    @Test
    public void crear_happyPath_ReturnLong() {
        Mockito.when( clienteRepository.save(cliente) ).thenReturn(cliente);
        Long pk = clienteService.crear(cliente);
        Assertions.assertEquals(1, pk);
    }

}
