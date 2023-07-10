package com.example.storage_project.service;

import com.example.storage_project.command.ContractorCommand;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.ContractorsDao;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.MyOrganization;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorService {
    private final ContractorsDao contractorsDao;

    public ContractorService(ContractorsDao contractorsDao) {
        this.contractorsDao = contractorsDao;
    }
    public List<Contractors> getAllContractors(Long id){
        List<Contractors> contractors = contractorsDao.getAllContractors(id);
        return contractors;
    }
    public void saveContractor(Contractors contractor){
        contractorsDao.saveContractor(contractor);
    }
    public void deleteContractorById(Long id){
        contractorsDao.deleteContractorById(id);
    }
    public void updateContractorById(ContractorUpdateCommand command){
        contractorsDao.updateContractorById(command);
    }
    public Contractors getContractorById(Long id){
       return contractorsDao.getContractorById(id);
    }
    public MyOrganization getMyOrganization(){
        return contractorsDao.getMyOrganization();
    }
}
