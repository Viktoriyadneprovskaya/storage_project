package com.example.storage_project.service;

import com.example.storage_project.command.contractor.ContractorCommand;
import com.example.storage_project.command.contractor.ContractorUpdateCommand;
import com.example.storage_project.dao.contractors.ContractorsDao;
import com.example.storage_project.model.contractor.*;
import com.example.storage_project.model.myOrganization.MyOrganization;
import com.example.storage_project.model.product.PriceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorService {
    private final ContractorsDao contractorsDao;
    private ContractorTypeService contractorTypeService;
    private final PriceTypeService priceTypeService;
    private final AddressService addressService;

    public ContractorService(ContractorsDao contractorsDao, ContractorTypeService contractorTypeService, PriceTypeService priceTypeService, AddressService addressService) {
        this.contractorsDao = contractorsDao;
        this.contractorTypeService = contractorTypeService;
        this.priceTypeService = priceTypeService;
        this.addressService = addressService;
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
    public Contractors getSavedContractor(ContractorCommand command){
        ContractorType contractorType = contractorTypeService.getContractorTypeById(command.getContractorType());
        PriceType priceType = priceTypeService.getPriceTypeById(command.getPriceType());
        Country country = addressService.getCountryById(command.getCountry());
        City city = addressService.getCityById(command.getCity());
        Contractors contractor = Contractors.builder()
                .code(command.getCode())
                .contractorName(command.getContractorName())
                .contractNumber(command.getContractNumber())
                .contractorType(contractorType)
                .priceType(priceType)
                .build();
        saveContractor(contractor);
        Address address = Address.builder()
                .index(command.getIndex())
                .street(command.getStreet())
                .houseNumber(command.getHouseNumber())
                .country(country)
                .city(city)
                .contractor(contractor)
                .build();
        addressService.saveAddress(address);
        return contractor;
    }
}
