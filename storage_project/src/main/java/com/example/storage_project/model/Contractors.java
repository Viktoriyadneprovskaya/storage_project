package com.example.storage_project.model;

import lombok.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor


@NamedQueries(
        {
                @NamedQuery(
                        name = "Contractors.findByContractorTypeId",
                        query = "from Contractors c join fetch c.contractorType join fetch c.priceType where c.contractorType.contractorTypeID = :contrTypeId"
                )
        }
)

@Entity
@Table(name = "contractors", schema = "storagedb")

public class Contractors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contractor")
    Long contractorId;
    int code;
    @Column(name = "contractor_name")
    String contractorName;
    @Column(name = "contract_number")
    String contractNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractortype_id")
    ContractorType contractorType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_type_id")
    PriceType priceType;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "contractor")
    List<Address> addresses = new ArrayList<>();

}
