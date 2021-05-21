package com.agile.supermarket.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.agile.supermarket.entities.pk.ProductInventoryHandlingPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_product_inventory_handling")
public class ProductInventoryHandling implements Serializable {
	private static final long serialVersionUID = -234534623095447242L;

	@EmbeddedId
	private ProductInventoryHandlingPK id;

	@Column(nullable = false)
	private Double amount;

	public ProductInventoryHandling(Product product, InventoryHandling inventoryHandling, Double amount) {
		this.id = new ProductInventoryHandlingPK(inventoryHandling, product);
		this.amount = amount;
	}

	@JsonIgnore
	public InventoryHandling getInventoryHandling() {
		return id.getInventoryHandling();
	}

	public Product getProduct() {
		return id.getProduct();
	}
}
