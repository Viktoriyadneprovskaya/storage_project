package com.example.storage_project.service;

import com.example.storage_project.command.document.DocDetailsUpdateModel;
import com.example.storage_project.dao.documents.DocDetailsDao;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.DocumentDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocDetailsService {
    private final DocDetailsDao docDetailsDao;

    public DocDetailsService(DocDetailsDao docDetailsDao) {
        this.docDetailsDao = docDetailsDao;
    }

    public List<DocumentDetails> getAllDocDetailsByDocumentId(Long docId){
        return docDetailsDao.getAllDocDetailsByDocumentId(docId);
    }
    public void saveDocumentDetails(DocumentDetails documentDetails) {
        docDetailsDao.saveDocumentDetails(documentDetails);
    }
    public void deleteDocDetailsById(Long id) {
        docDetailsDao.deleteDocDetailsById(id);
    }
    public void updateDocDetailsById(DocDetailsUpdateModel docDetailsUpdateModel, Contractors contractor, Long invoiceType){
        docDetailsDao.updateDocDetailsById(docDetailsUpdateModel,contractor, invoiceType);
    }
}
