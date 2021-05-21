package com.agile.supermarket.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.agile.supermarket.entities.pk.OrderProductPK;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_order_product")
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 5157633211572808540L;

	@EmbeddedId
	private OrderProductPK id;

	@Column(nullable = false)
	private Double amount;

	@Column(nullable = false)
	private Double unitPrice;

	public OrderProduct(Order order, Product product, Double amount, Double unitPrice) {
		this.id = new OrderProductPK(order, product);
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
}
