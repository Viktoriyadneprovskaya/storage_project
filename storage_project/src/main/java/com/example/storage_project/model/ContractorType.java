package com.example.storage_project.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "contractor_type", schema = "storagedb")
public class ContractorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contractor_type")
    Long contractorTypeID;
    @Column(name = "contractor_type")
    String contractorType;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractorType")
//    private List<Contractors> contractors = new ArrayList<>();
}
