package com.example.storage_project;

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
@Table(name = "product", schema = "storageDB")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    Long productId;
    String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_unit")
    MeasureUnit measureUnit;
    String shelfLife;
    @Column(name = "basic_price")
    double basicPrice;

}

