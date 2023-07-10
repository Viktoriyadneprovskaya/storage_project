package com.example.storage_project.controller;

import com.example.storage_project.command.AddressCommand;
import com.example.storage_project.model.*;
import com.example.storage_project.service.AddressService;
import com.example.storage_project.service.ContractorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewAddressController {
    private final AddressService addressService;
    private final ContractorService contractorService;

    public NewAddressController(AddressService addressService, ContractorService contractorService) {
        this.addressService = addressService;
        this.contractorService = contractorService;
    }

    @GetMapping
    public String getNewAddressPage(Model model) {
        List<Country> countries = addressService.getAllCountries();
        List<City> cities = addressService.getAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("countries", countries);
        return "new_address";
    }

    @PostMapping("/save")
    public String saveAddress(@ModelAttribute("address") AddressCommand command, @RequestParam("contractorId") Long contractorId) {
        Country country = addressService.getCountryById(command.getCountry());
        City city = addressService.getCityById(command.getCity());
        Contractors contractor = contractorService.getContractorById(contractorId);
        Address address = Address.builder()
                .index(command.getIndex())
                .street(command.getStreet())
                .houseNumber(command.getHouseNumber())
                .country(country)
                .city(city)
                .contractor(contractor)
                .build();
        addressService.saveAddress(address);
        return "redirect:/contractors/"+contractorId;
    }
}
