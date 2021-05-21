package com.agile.supermarket.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 4209761490049088895L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String barcode;

	@Column(nullable = false)
	private Double salePrice;

	@OneToMany(mappedBy = "id.product")
	private Set<ProductInventoryHandling> handlings = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	private Set<OrderProduct> orders = new HashSet<>();

	public Product(Long id, String name, String barcode, Double salePrice) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.salePrice = salePrice;
	}

	public Double getAmount() {
		return handlings.stream().map(x -> x.getAmount()).reduce(0.0, (x, y) -> x + y)
				- orders.stream().map(x -> x.getAmount()).reduce(0.0, (x, y) -> x + y);
	}

	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> set = new HashSet<>();
		for (OrderProduct x : orders) {
			set.add(x.getOrder());
		}
		return set;
	}

	@JsonIgnore
	public Set<InventoryHandling> getHandlings() {
		Set<InventoryHandling> set = new HashSet<>();
		for (ProductInventoryHandling x : handlings) {
			set.add(x.getInventoryHandling());
		}
		return set;
	}
}
