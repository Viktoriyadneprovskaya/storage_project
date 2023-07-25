package com.example.storage_project.command;

import com.example.storage_project.model.ContractorType;
import com.example.storage_project.model.PriceType;
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
public class ContractorUpdateCommand {
    Long contractorId;
    int code;
    String contractorName;
    String contractNumber;
    Long contractorType;
    Long priceType;
    int index;
    String street;
    String houseNumber;
    Long city;
    Long country;

}
