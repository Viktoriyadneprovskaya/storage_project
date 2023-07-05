package com.example.storage_project.model;

import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "product", schema = "storagedb")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    Long productId;
    String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_unit")
    MeasureUnit measureUnit;
    String shelfLife;
    @Column(name = "basic_price")
    Double basicPrice;

}

