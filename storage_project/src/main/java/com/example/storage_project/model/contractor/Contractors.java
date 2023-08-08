package com.example.storage_project.model.contractor;

import com.example.storage_project.model.product.PriceType;
import lombok.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractortype_id")
    ContractorType contractorType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price_type_id")
    PriceType priceType;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "contractor")
    Address address;

}
