package com.example.storage_project.command;

import com.example.storage_project.Contractors;
import com.example.storage_project.MeasureUnit;
import com.example.storage_project.Product;

import java.util.ArrayList;
import java.util.List;

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
    private Long productId;
    private int number;
    private String name;
    private MeasureUnit measureUnit;
    private String shelfLife;
    private double basicPrice;

    public static ProductCommand productToCommand(Product product) {
        return ProductCommand.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .measureUnit(product.getMeasureUnit())
                .shelfLife(product.getShelfLife())
                .basicPrice(product.getBasicPrice())
                .build();
    }

    public static List<ProductCommand> productsToCommand(List<Product> products) {
        List<ProductCommand> productCommand = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            ProductCommand command = productToCommand(products.get(i));
            command.setNumber(i + 1);
            productCommand.add(command);
        }
        return productCommand;
    }
}
