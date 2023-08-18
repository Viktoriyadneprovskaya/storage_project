package com.example.storage_project.model.document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.myOrganization.MyOrganization;
import com.example.storage_project.model.product.PriceType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor

@org.hibernate.annotations.NamedQueries(
        {
                @org.hibernate.annotations.NamedQuery(
                        name = "Document.findByInvoiceTypeId",
                        query = "from Document d join fetch d.contractor join fetch d.priceType join fetch d.myOrganization join fetch d.invoiceType where d.invoiceType.invoiceTypeId = :invoice_type"
                )
        }
)

@Entity
@Table(name = "document", schema = "storagedb")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    Long documentId;
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate creationDate;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor")
    Contractors contractor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_type")
    PriceType priceType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "my_organization_id")
    MyOrganization myOrganization;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_type")
    InvoiceType invoiceType;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "document")
    List<DocumentDetails> documentDetails = new ArrayList<>();
}
