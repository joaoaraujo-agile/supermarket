package com.agile.supermarket.resources;

import com.agile.supermarket.dto.OrderDTO;
import com.agile.supermarket.entities.Order;
import com.agile.supermarket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderResource {

	private final OrderService service;

	@Autowired
	public OrderResource(OrderService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Order> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Order findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody OrderDTO obj) {
		Order entity = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(entity);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Order update(@PathVariable Long id, @RequestBody OrderDTO obj) {
		return service.update(id, obj);
	}
}
