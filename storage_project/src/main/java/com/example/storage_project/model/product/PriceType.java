package com.example.storage_project.model.product;

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
@Table(name = "price_type", schema = "storageDB")
public class PriceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_price_type")
    Long priceTypeId;
    @Column(name = "price_type")
    String priceType;
    @Column(name = "charge_percent")
    double chargePercent;
}
