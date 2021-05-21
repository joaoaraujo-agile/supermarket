package com.agile.supermarket.resources;

import com.agile.supermarket.dto.InventoryHandlingDTO;
import com.agile.supermarket.entities.InventoryHandling;
import com.agile.supermarket.services.InventoryHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/inventoryhandlings")
public class InventoryHandlingResource {

	private final InventoryHandlingService service;

	@Autowired
	public InventoryHandlingResource(InventoryHandlingService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<InventoryHandling> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InventoryHandling findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<InventoryHandling> insert(@RequestBody InventoryHandlingDTO obj) {
		InventoryHandling entity = service.insert(obj);
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
	public InventoryHandling update(@PathVariable Long id, @RequestBody InventoryHandlingDTO obj) {
		return service.update(id, obj);
	}
}
