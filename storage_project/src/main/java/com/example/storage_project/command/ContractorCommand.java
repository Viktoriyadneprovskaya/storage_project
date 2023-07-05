package com.example.storage_project.command;

import com.example.storage_project.model.ContractorType;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.PriceType;
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
