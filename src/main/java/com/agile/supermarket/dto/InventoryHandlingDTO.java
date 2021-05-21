package com.agile.supermarket.dto;

import com.agile.supermarket.entities.*;
import com.agile.supermarket.services.InventoryHandlingService;
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
public class InventoryHandlingDTO implements Serializable {
    private static final long serialVersionUID = 2355992545951994957L;

    private Long id;
    private LocalDateTime datetime;
    private Set<ProductInventoryHandling> items = new HashSet<>();

    public static InventoryHandlingDTO toDTO(InventoryHandling obj) {
        return new InventoryHandlingDTO(obj.getId(), obj.getDatetime(), obj.getItems());
    }

    public InventoryHandling toObj() {
        return new InventoryHandling(id, datetime, items);
    }
}
