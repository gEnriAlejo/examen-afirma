package com.afirma.apiexamenafirma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afirma.apiexamenafirma.repository.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
