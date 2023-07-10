package com.example.storage_project.command;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AddressCommand {
    private Long country;
    private Long city;
    int index;
    String street;
    String houseNumber;
}
