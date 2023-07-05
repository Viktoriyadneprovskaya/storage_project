package com.example.storage_project.command;

import com.example.storage_project.model.City;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.Country;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AddressUpdateCommand {
    int index;
    String street;
    City city;
    Country country;
    Contractors contractor;
}
