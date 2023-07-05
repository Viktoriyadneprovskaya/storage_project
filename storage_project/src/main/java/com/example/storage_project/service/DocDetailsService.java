package com.example.storage_project.service;

import com.example.storage_project.dao.DocDetailsDao;
import com.example.storage_project.model.DocumentDetails;
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
}
