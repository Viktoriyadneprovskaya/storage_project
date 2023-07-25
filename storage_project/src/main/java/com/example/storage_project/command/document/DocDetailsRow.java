package com.example.storage_project.command.document;

import com.example.storage_project.model.MeasureUnit;
import com.example.storage_project.model.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocDetailsRow {
    List<Product> products;
    List<MeasureUnit> measureUnits;
}
