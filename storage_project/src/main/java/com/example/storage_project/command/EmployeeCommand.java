package com.example.storage_project.command;


import com.example.storage_project.model.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EmployeeCommand {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long jobTitle;

}
