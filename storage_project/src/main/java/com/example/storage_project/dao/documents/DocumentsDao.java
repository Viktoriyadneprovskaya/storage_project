package com.example.storage_project.dao.documents;

import com.example.storage_project.model.document.Document;

import java.util.List;

public interface DocumentsDao {
    List<Document> getAllDocuments(Long invoiceType);
    void saveDocument (Document document);
    void deleteDocumentById(Long id);
    Document getDocumentById(Long id);
}
