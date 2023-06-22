package com.example.storage_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "document", schema = "storageDB")

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    Long documentId;
    @Column(name = "creation_date")
    LocalDate creationDate = LocalDate.now();
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "my_organisation")
    Contractors contractor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage")
    Storage storageName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_type")
    PriceType priceType;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "my_organisation")
//    Contractors myOrganization;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_type")
    InvoiceType invoiceType;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "document")
    List<DocumentDetails> documentDetails = new ArrayList<>();


}
