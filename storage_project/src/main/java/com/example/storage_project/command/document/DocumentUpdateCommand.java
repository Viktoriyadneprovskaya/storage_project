package com.example.storage_project.command.document;

import com.example.storage_project.model.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DocumentUpdateCommand {
    Long id;
    Contractors contractor;
    MyOrganization myOrganization;
    List<DocDetailsSelected> docDetailsSelected;
    List<Product> products;
    List<MeasureUnit> measureUnits;
    InvoiceType invoiceType;
    LocalDate creationDate;
    Long documentId;
}