package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
