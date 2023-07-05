package com.example.storage_project.dao;

import com.example.storage_project.model.Document;
import com.example.storage_project.model.DocumentDetails;

import java.util.List;

public interface DocumentsDao {
    List<Document> getAllDocuments(Long invoiceType);
    void saveDocument (Document document);
    void deleteDocumentById(Long id);
//    void updateDocumentById(Long id, DocumentUpdateCommand command);
    Document getDocumentById(Long id);
}
