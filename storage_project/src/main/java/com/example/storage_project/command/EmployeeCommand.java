package com.example.storage_project.command;

import com.example.storage_project.Employee;
import com.example.storage_project.JobTitle;
import com.example.storage_project.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EmployeeCommand {
    private Long id;
    private int number;
    private String firstName;
    private String lastName;
    private JobTitle jobTitle;

    public static EmployeeCommand employeeToCommand(Employee employee) {
        return EmployeeCommand.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .jobTitle(employee.getJobTitle())
                .build();
    }

    public static List<EmployeeCommand> employeesToCommand(List<Employee> employees) {
        List<EmployeeCommand> employeeCommands = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            EmployeeCommand command = employeeToCommand(employees.get(i));
            command.setNumber(i + 1);
            employeeCommands.add(command);
        }
        return employeeCommands;
    }
}
