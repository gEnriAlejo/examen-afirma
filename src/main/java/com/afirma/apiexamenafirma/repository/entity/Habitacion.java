package com.afirma.apiexamenafirma.repository.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHabitacion;
	@Column
	private String numero;
	@Column
	private String tipo;
	@Column
	private String descripcion;
	@Column
	private int capacidad;
	@Column
	private BigDecimal PrecioPorNoche;
	
}
