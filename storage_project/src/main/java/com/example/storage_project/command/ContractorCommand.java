package com.example.storage_project.command;

import com.example.storage_project.ContractorType;
import com.example.storage_project.Contractors;
import com.example.storage_project.PriceType;
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
    private Long contractorID;
    private int number;
    private int code;
    private String contractorName;
    private String contractNumber;
    private ContractorType contractorType;
    private PriceType priceType;

    public static ContractorCommand contractorToCommand(Contractors contractor) {
        return ContractorCommand.builder()
                .contractorID(contractor.getContractorID())
                .code(contractor.getCode())
                .contractorName(contractor.getContractorName())
                .contractNumber(contractor.getContractNumber())
                .contractorType(contractor.getContractorType())
                .priceType(contractor.getPriceType())
                .build();
    }

    public static List<ContractorCommand> contractorsToCommand(List<Contractors> contractors) {
        List<ContractorCommand> contractorsCommand = new ArrayList<>();
        for (int i = 0; i < contractors.size(); i++) {
            ContractorCommand command = contractorToCommand(contractors.get(i));
            command.setNumber(i + 1);
            contractorsCommand.add(command);
        }
        return contractorsCommand;
    }
}
