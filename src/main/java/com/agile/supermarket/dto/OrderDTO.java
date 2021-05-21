package com.agile.supermarket.dto;

import com.agile.supermarket.entities.Order;
import com.agile.supermarket.entities.OrderProduct;
import com.agile.supermarket.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 2355992545951994957L;

    private Long id;
    private LocalDateTime datetime;
    private Payment payment;
    private Set<OrderProduct> items = new HashSet<>();

    public static OrderDTO toDTO(Order obj) {
        return new OrderDTO(obj.getId(), obj.getDatetime(), obj.getPayment(), obj.getItems());
    }

    public Order toObj() {
        return new Order(id, datetime, payment, items);
    }
}
