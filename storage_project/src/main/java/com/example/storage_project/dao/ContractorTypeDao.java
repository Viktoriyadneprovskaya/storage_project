package com.example.storage_project.dao;

import com.example.storage_project.model.ContractorType;

import java.util.List;

public interface ContractorTypeDao {
    List<ContractorType> getAllContractorTypes();
    ContractorType getContractorTypeById(Long id);
}
