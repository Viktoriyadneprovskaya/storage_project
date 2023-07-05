package com.example.storage_project.service;

import com.example.storage_project.dao.ContractorTypeDao;
import com.example.storage_project.model.ContractorType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorTypeService {
    private final ContractorTypeDao contractorTypeDao;

    public ContractorTypeService(ContractorTypeDao contractorTypeDao) {
        this.contractorTypeDao = contractorTypeDao;
    }
    public List<ContractorType> getAllContractorTypes(){
        return contractorTypeDao.getAllContractorTypes();
    }
    public ContractorType getContractorTypeById(Long id){
        return contractorTypeDao.getContractorTypeById(id);
    }
}
