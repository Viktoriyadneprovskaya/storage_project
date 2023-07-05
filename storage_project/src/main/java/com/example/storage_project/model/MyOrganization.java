package com.example.storage_project.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "my_organization", schema = "storageDB")
public class MyOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_my_organization")
    Long id;
    String name;
    int number;
    String address;
}
