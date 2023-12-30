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

import com.afirma.apiexamenafirma.repository.entity.Reserva;
import com.afirma.apiexamenafirma.service.IReservaService;

@SpringBootTest
@ContextConfiguration(classes = ReservaController.class)
public class ReservaControllerTest {
	
	private static Reserva reserva;
	
    @Autowired
    private ReservaController reservaController;
    @MockBean
    private IReservaService reservaService;
    
    @BeforeAll
    static void beforeAll() {
    	reserva = new Reserva();
    }

    @Test
    public void consultarTodos_whenConsultaIsOK_return200() {
        ResponseEntity<List<Reserva>> response = reservaController.consultarTodos();
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void consultarTodos_whenCreaIsOK_return201() {
        ResponseEntity<Long> response = reservaController.crea(reserva);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void consultarTodos_whenModificaIsOK_return200() {
        ResponseEntity<Void> response = reservaController.modifica(reserva);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void consultarTodos_whenEliminaIsOK_return200() {
        ResponseEntity<Void> response = reservaController.elimina(1);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

}
