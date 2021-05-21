package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
