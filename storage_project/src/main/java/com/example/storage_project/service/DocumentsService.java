package com.example.storage_project.service;

import com.example.storage_project.dao.DocumentsDao;
import com.example.storage_project.model.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsService {
    private final DocumentsDao documentsDao;

    public DocumentsService(DocumentsDao documentsDao) {
        this.documentsDao = documentsDao;
    }

    public List<Document> getAllDocuments(Long invoiceType){
        return documentsDao.getAllDocuments(invoiceType);
    }
    public Document getDocumentById(Long docId){
        return documentsDao.getDocumentById(docId);
    }
    public void saveDocument(Document document) {
        documentsDao.saveDocument(document);
    }
    public void deleteDocumentById(Long id) {
        documentsDao.deleteDocumentById(id);
    }
}
