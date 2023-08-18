package com.example.storage_project.command.employee;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor

public class EmployeeDTO {
    Long id;
    String username;
    String firstName;
    String lastName;
    String jobTitle;
}

