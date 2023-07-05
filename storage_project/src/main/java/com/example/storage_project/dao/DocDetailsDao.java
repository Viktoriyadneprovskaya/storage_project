package com.example.storage_project.dao;

import com.example.storage_project.model.DocumentDetails;

import java.util.List;

public interface DocDetailsDao {
    List<DocumentDetails> getAllDocDetailsByDocumentId(Long docId);
//    void saveDocumentDetails();
//    void deleteDocDetailsById(Long id);
//    void updateDocDetailsById(Long id, DocumentUpdateCommand command);
}
