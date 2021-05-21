package com.agile.supermarket.services;

import com.agile.supermarket.dto.ProductDTO;
import com.agile.supermarket.entities.Product;
import com.agile.supermarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository repository;

	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
//		TODO Exception handling when obj doesn't exist
	}
	
	public Product insert(ProductDTO obj) {
		return repository.save(obj.toObj());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Product update(Long id, ProductDTO obj) {
		Product entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Product entity, ProductDTO obj) {
		entity.setName(obj.getName());
		entity.setBarcode(obj.getBarcode());
		entity.setSalePrice(obj.getSalePrice());
	}
}
