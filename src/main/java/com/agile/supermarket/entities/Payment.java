package com.agile.supermarket.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.agile.supermarket.entities.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 4615375413770900526L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentMethod method;

	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;

	public Double getValue() {
		return order.getItems().stream().map(
				x -> x.getAmount() * x.getUnitPrice()
		).reduce(0.0, (x, y) -> x + y);
	}
}
