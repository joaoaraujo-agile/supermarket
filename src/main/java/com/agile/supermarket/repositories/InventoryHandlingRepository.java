package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.InventoryHandling;

public interface InventoryHandlingRepository extends JpaRepository<InventoryHandling, Long> {
}
