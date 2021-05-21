package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
