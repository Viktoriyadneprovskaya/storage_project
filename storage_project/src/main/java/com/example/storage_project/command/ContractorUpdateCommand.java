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
    Long id;
    int code;
    String contractorName;
    String contractNumber;
    ContractorType contractorType;
    PriceType priceType;
}
