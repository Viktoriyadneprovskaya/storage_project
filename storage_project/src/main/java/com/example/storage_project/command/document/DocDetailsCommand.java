package com.example.storage_project.command.document;
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
    int productSelect;
    int unitSelect;
    double quantitySelect;
}
