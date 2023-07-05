package com.example.storage_project.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "document_details", schema = "storageDB")
public class DocumentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document_details")
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    MeasureUnit unit;
    double quantity;
    double price;//метод, который получает цену с учетом прайстайп и контрактортайп
    double sum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    Document document;



}
