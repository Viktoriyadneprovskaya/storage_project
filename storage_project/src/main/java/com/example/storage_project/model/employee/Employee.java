package com.example.storage_project.model.employee;

import com.example.storage_project.model.security.Role;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor

@Entity
@Table(name = "employees", schema = "storagedb")
@org.hibernate.annotations.NamedQueries(
        {
                @org.hibernate.annotations.NamedQuery(
                        name = "Employee.findEmployeeByUserName",
                        query = "from Employee e where e.username = :username"
                )
        }

)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_title_id")
    JobTitle jobTitle;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles",
            joinColumns = {@JoinColumn(name = "id_employee", referencedColumnName = "id_employee")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private List<Role> roles;
}