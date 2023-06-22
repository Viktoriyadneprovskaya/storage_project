package com.example.storage_project.dao.impl;

import com.example.storage_project.Contractors;
import com.example.storage_project.command.ContractorUpdateCommand;

import java.util.List;

public interface ContractorsDao {
    List<Contractors> getAllContractors(Long id);
    void deleteContractorById(Long id);
    void updateContractorById(Long id, ContractorUpdateCommand command);
}
