package com.agile.supermarket.services;

import com.agile.supermarket.dto.InventoryHandlingDTO;
import com.agile.supermarket.entities.InventoryHandling;
import com.agile.supermarket.repositories.InventoryHandlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryHandlingService {

	private final InventoryHandlingRepository repository;

	@Autowired
	public InventoryHandlingService(InventoryHandlingRepository repository) {
		this.repository = repository;
	}
	
	public List<InventoryHandling> findAll() {
		return repository.findAll();
	}

	public InventoryHandling findById(Long id) {
		Optional<InventoryHandling> obj = repository.findById(id);
		return obj.get();
//		TODO Exception handling when obj doesn't exist
	}
	
	public InventoryHandling insert(InventoryHandlingDTO obj) {
		return repository.save(obj.toObj());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public InventoryHandling update(Long id, InventoryHandlingDTO obj) {
		InventoryHandling entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(InventoryHandling entity, InventoryHandlingDTO obj) {
		entity.setDatetime(obj.getDatetime());
		entity.setItems(obj.getItems());
	}
}
