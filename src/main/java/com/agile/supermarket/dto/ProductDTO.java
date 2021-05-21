package com.agile.supermarket.dto;

import com.agile.supermarket.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String barcode;
    private Double salePrice;

    public static ProductDTO toDTO(Product obj) {
        return new ProductDTO(obj.getId(), obj.getName(), obj.getBarcode(), obj.getSalePrice());
    }

    public Product toObj() {
        Product obj = new Product();
        obj.setId(id);
        obj.setName(name);
        obj.setBarcode(barcode);
        obj.setSalePrice(salePrice);
        return obj;
    }
}
