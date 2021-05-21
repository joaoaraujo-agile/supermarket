package com.agile.supermarket.services;

import java.util.List;
import java.util.Optional;

import com.agile.supermarket.dto.OrderDTO;
import com.agile.supermarket.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.agile.supermarket.repositories.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository repository;

	@Autowired
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}
	
	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
//		TODO Exception handling when obj doesn't exist
	}
	
	public Order insert(OrderDTO obj) {
		return repository.save(obj.toObj());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Order update(Long id, OrderDTO obj) {
		Order entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Order entity, OrderDTO obj) {
		entity.setDatetime(obj.getDatetime());
		entity.setPayment(obj.getPayment());
		entity.setItems(obj.getItems());
	}
}
