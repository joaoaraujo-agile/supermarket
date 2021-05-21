package com.agile.supermarket.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = -6880304230649781440L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime datetime;

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Payment payment;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderProduct> items = new HashSet<>();

	public Order(Long id, LocalDateTime datetime, Payment payment) {
		this.id = id;
		this.datetime = datetime;
		this.payment = payment;
	}
}
