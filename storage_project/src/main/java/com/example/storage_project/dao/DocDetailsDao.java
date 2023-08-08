package com.example.storage_project.dao;

import com.example.storage_project.command.document.DocDetailsUpdateModel;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.DocumentDetails;

import java.util.List;

public interface DocDetailsDao {
    List<DocumentDetails> getAllDocDetailsByDocumentId(Long docId);
    void saveDocumentDetails(DocumentDetails documentDetails);
    void deleteDocDetailsById(Long id);
    void updateDocDetailsById(DocDetailsUpdateModel docDetailsUpdateModel, Contractors contractor, Long invoiceType);
}
