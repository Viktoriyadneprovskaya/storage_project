package com.example.storage_project.command;
import com.example.storage_project.model.Document;
import com.example.storage_project.model.DocumentDetails;
import com.example.storage_project.model.MeasureUnit;
import com.example.storage_project.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocDetailsCommand {
    private Long id;
    private int number;
    private Product product;
    private MeasureUnit unit;
    private double quantity;
    private double price;//метод, который получает цену с учетом прайстайп и контрактортайп
    private double sum;
    private Document document;


}
