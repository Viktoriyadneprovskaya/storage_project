package com.example.storage_project.command;

import com.example.storage_project.model.MeasureUnit;

import com.example.storage_project.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ProductCommand {
    private String name;
    private Long measureUnit;
    private String shelfLife;
    private double basicPrice;

    public Product commandToProduct(ProductCommand product, MeasureUnit measureUnit) {
        return Product.builder()
                .name(product.getName())
                .measureUnit(measureUnit)
                .shelfLife(product.getShelfLife())
                .basicPrice(product.getBasicPrice())
                .build();
    }

}
