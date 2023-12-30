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

import com.afirma.apiexamenafirma.repository.ReservaRepository;
import com.afirma.apiexamenafirma.repository.entity.Reserva;

@SpringBootTest
@ContextConfiguration(classes = ReservaService.class)
public class ReservaServiceTest {
	
    private static List<Reserva> reservas;
    private static Reserva reserva;
	
    @Autowired
    private ReservaService reservaService;
    @MockBean
    private ReservaRepository reservaRepository;
    
    @BeforeAll
    static void beforeAll() {
    	reserva = Reserva
    			.builder()
    			.idReserva(1)
    			.build();
    	reservas = List.of(new Reserva(), new Reserva());
    }
    
    @Test
    public void consultarTodos_happyPath_ReturnList() {
        Mockito.when( reservaRepository.findAll() ).thenReturn(reservas);
        List<Reserva> reservas = reservaService.consultarTodos();
        Assertions.assertNotNull(reservas);
        Assertions.assertEquals(2, reservas.size());
    }
    
    @Test
    public void crear_happyPath_ReturnLong() {
        Mockito.when( reservaRepository.save(reserva) ).thenReturn(reserva);
        Long pk = reservaService.crear(reserva);
        Assertions.assertEquals(1, pk);
    }

}
