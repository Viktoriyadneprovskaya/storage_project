package com.example.storage_project.dao;

import com.example.storage_project.command.ContractorCommand;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.model.MyOrganization;

import java.util.List;

public interface ContractorsDao {
    List<Contractors> getAllContractors(Long id);
    void saveContractor (Contractors contractor);
    void deleteContractorById(Long id);
    void updateContractorById(ContractorUpdateCommand command);
    Contractors getContractorById(Long id);
    MyOrganization getMyOrganization();
}
