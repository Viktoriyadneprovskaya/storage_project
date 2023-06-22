package com.example.storage_project.dao.impl;

import com.example.storage_project.Contractors;
import com.example.storage_project.DocumentDetails;
import com.example.storage_project.command.ContractorUpdateCommand;

import java.util.List;

public interface DocDetailsDao {
    List<DocumentDetails> getAllDocDetails();//Long id
    void deleteDocDetailsById(Long id);
    void updateDocDetailsById(Long id, ContractorUpdateCommand command);
}
