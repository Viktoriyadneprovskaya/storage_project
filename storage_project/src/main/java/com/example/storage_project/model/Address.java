package com.example.storage_project.model;

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

@Entity
@Table(name = "address", schema = "storageDB")
@NamedQueries(
        {
                @NamedQuery(
                        name = "Address.findAddressesByContractorId",
                        query = "from Address e join fetch e.city join fetch e.country join fetch e.contractor where e.contractor.contractorId = :id"
                )
        }
)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    Long addressId;
    int index;
    String street;
    @Column(name = "house_number")
    String houseNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")
    City city;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country")
    Country country;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contractor")
    private Contractors contractor;
}
