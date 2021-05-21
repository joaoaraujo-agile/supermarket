package com.agile.supermarket.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.agile.supermarket.entities.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 4615375413770900526L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;

	@Column(nullable = false)
	private Integer method;

	@JsonIgnore
	@OneToOne
	@MapsId
	@Getter @Setter
	private Order order;

	public Payment(Long id, PaymentMethod method, Order order) {
		this.id = id;
		setPaymentMethod(method);
		this.order = order;
	}

	public Double getValue() {
		return order.getItems().stream().map(
				x -> x.getAmount() * x.getUnitPrice()
		).reduce(0.0, (x, y) -> x + y);
	}

	public PaymentMethod getMethod() {
		return PaymentMethod.valueOf(method);
	}

	public void setPaymentMethod(PaymentMethod method) {
		if (method != null) {
			this.method = method.getCode();
		}
	}
}
