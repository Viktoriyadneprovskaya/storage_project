package com.example.storage_project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "address", schema = "storageDB")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    Long addressId;
    int index;
    String street;
    @Column(name = "house_number")
    int houseNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")
    City city;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country")
    Country country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contractor")
    private Contractors contractor;
}
