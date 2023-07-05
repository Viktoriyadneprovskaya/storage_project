package com.example.storage_project.controller;

import com.example.storage_project.command.ContractorCommand;
import com.example.storage_project.model.*;
import com.example.storage_project.service.AddressService;
import com.example.storage_project.service.ContractorService;
import com.example.storage_project.service.ContractorTypeService;
import com.example.storage_project.service.PriceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/new_contractor")
public class NewContractorController {
    private final ContractorService contractorService;
    private final AddressService addressService;
    private final ContractorTypeService contractorTypeService;
    private final PriceTypeService priceTypeService;

    public NewContractorController(ContractorService contractorService, AddressService addressService, ContractorTypeService contractorTypeService, PriceTypeService priceTypeService) {
        this.contractorService = contractorService;
        this.addressService = addressService;
        this.contractorTypeService = contractorTypeService;
        this.priceTypeService = priceTypeService;
    }

    @GetMapping
    public String getNewContractorPage(Model model) {
        List<ContractorType> contractorTypes = contractorTypeService.getAllContractorTypes();
        List<PriceType> priceTypes =priceTypeService.getAllPriceTypes();
        List<Country> countries = addressService.getAllCountries();
        List<City> cities = addressService.getAllCities();
        model.addAttribute("contractorTypes", contractorTypes);
        model.addAttribute("priceTypes", priceTypes);
        model.addAttribute("cities",cities);
        model.addAttribute("countries", countries);
        return "new_contractor";
    }

    @PostMapping("/save")
    public String saveContractor(@ModelAttribute("contractor") ContractorCommand command) {
        ContractorType contractorType = contractorTypeService.getContractorTypeById(command.getContractorType());
        PriceType priceType = priceTypeService.getPriceTypeById(command.getPriceType());
        Country country = addressService.getCountryById(command.getCountry());
        City city = addressService.getCityById(command.getCity());
        Address address = Address.builder()
                .index(command.getIndex())
                .street(command.getStreet())
                .houseNumber(command.getHouseNumber())
                .country(country)
                .city(city)
                .build();
        addressService.saveAddress(address);//как сюда добавить id контрактора если его нет?
        List<Address> addresses = List.of(address);

        Contractors contractor = Contractors.builder()
                .code(command.getCode())
                .contractorName(command.getContractorName())
                .contractNumber(command.getContractNumber())
                .contractorType(contractorType)
                .priceType(priceType)
                .addresses(addresses)
                .build();

//        contractorService.setContractorToAddress(contractorService.saveContractor(contractor);

        return "redirect:/contractors?contrTypeId="+contractor.getContractorType().getContractorTypeID();
    }
}
