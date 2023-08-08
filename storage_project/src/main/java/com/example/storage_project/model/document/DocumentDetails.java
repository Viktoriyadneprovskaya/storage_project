package com.example.storage_project.model.document;

import com.example.storage_project.model.product.MeasureUnit;
import com.example.storage_project.model.product.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
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
    double price;
    double sum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    Document document;

}
