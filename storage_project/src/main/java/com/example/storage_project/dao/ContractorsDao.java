package com.example.storage_project.dao;

import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.command.contractor.ContractorUpdateCommand;
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
