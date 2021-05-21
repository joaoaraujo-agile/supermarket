package com.agile.supermarket.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_inventory_handling")
public class InventoryHandling implements Serializable {
	private static final long serialVersionUID = -8580710353571527487L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime datetime;

	@OneToMany(mappedBy = "id.inventoryHandling")
	private Set<ProductInventoryHandling> items = new HashSet<>();

	public InventoryHandling(Long id, LocalDateTime datetime) {
		this.id = id;
		this.datetime = datetime;
	}
}
