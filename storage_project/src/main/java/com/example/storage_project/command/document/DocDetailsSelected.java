package com.example.storage_project.command.document;

import com.example.storage_project.model.product.MeasureUnit;
import com.example.storage_project.model.product.Product;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocDetailsSelected {
    Long id;
    Product selectedProduct;
    MeasureUnit selectedMeasureUnit;
    double selectedQuantity;
    double price;
}
