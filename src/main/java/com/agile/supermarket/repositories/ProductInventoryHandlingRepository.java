package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.ProductInventoryHandling;

public interface ProductInventoryHandlingRepository extends JpaRepository<ProductInventoryHandling, Long> {
}
