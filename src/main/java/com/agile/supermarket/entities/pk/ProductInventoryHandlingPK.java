package com.agile.supermarket.entities.pk;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.agile.supermarket.entities.InventoryHandling;
import com.agile.supermarket.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductInventoryHandlingPK implements Serializable {
	private static final long serialVersionUID = -8437467082172490797L;

	@ManyToOne
	@JoinColumn(name = "inventoryhandling_id")
	private InventoryHandling inventoryHandling;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
