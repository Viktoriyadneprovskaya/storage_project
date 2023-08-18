package com.example.storage_project.dao.contractors;

import com.example.storage_project.model.contractor.ContractorType;

import java.util.List;

public interface ContractorTypeDao {
    List<ContractorType> getAllContractorTypes();
    ContractorType getContractorTypeById(Long id);
}
