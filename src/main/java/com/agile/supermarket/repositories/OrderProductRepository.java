package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
