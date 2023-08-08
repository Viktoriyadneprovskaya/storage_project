package com.example.storage_project.model.security;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@org.hibernate.annotations.NamedQueries(
        {
                @org.hibernate.annotations.NamedQuery(
                        name = "Role.findByName",
                        query = "from Role r where r.name = :name"
                )
        }

)
public class Role {
    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;
    private String name;
}
