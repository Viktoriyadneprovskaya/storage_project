package com.example.storage_project.command.contractor;

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
public class ContractorCommand {
    private int code;
    private String contractorName;
    private String contractNumber;
    private Long contractorType;
    private Long priceType;
    private Long country;
    private Long city;
    int index;
    String street;
    String houseNumber;


}
