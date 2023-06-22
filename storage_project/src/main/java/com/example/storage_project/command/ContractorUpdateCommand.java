package com.example.storage_project.command;

import java.time.LocalDate;

import com.example.storage_project.ContractorType;
import com.example.storage_project.PriceType;
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
    int code;
    String contractorName;
    String contractNumber;
    ContractorType contractorType;
    PriceType priceType;
}
