package com.example.storage_project.controller;

import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.model.*;
import com.example.storage_project.service.AddressService;
import com.example.storage_project.service.ContractorService;
import com.example.storage_project.service.ContractorTypeService;
import com.example.storage_project.service.PriceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contractors")
public class ContractorController {
    private final ContractorService contractorService;
    private final AddressService addressService;
    private final ContractorTypeService contractorTypeService;
    private final PriceTypeService priceTypeService;

    public ContractorController(ContractorService contractorService, AddressService addressService, ContractorTypeService contractorTypeService, PriceTypeService priceTypeService) {
        this.contractorService = contractorService;
        this.addressService = addressService;
        this.contractorTypeService = contractorTypeService;
        this.priceTypeService = priceTypeService;
    }

    @GetMapping
    public String getAllContractors(Model model, @RequestParam("contrTypeId") Long contrTypeId) {
        List<Contractors> contractors = contractorService.getAllContractors(contrTypeId);
//        List<ContractorType> contractorTypes = contractorTypeService.getAllContractorTypes();
//        List<PriceType> priceTypes = priceTypeService.getAllPriceTypes();
        model.addAttribute("contractors", contractors);
//        model.addAttribute("contractorTypes", contractorTypes);
//        model.addAttribute("priceTypes",priceTypes);
        return "contractors";
    }

    @GetMapping("/delete")
    public String deleteContractor(@RequestParam("id") Long id, @RequestParam("contrTypeId") Long contrTypeId) {
        contractorService.deleteContractorById(id);
        return "redirect:/contractors?contrTypeId=" + contrTypeId;
    }

    @GetMapping("/{contractor_id}")
    public String getAFullInformationByContractorId(Model model, @PathVariable Long contractor_id) {
        Contractors contractor = contractorService.getContractorById(contractor_id);
        Address address = addressService.findAddressByContractorId(contractor_id);
        List<ContractorType> contractorTypes = contractorTypeService.getAllContractorTypes();
        List<PriceType> priceTypes = priceTypeService.getAllPriceTypes();
        List<Country> countries = addressService.getAllCountries();
        List<City> cities = addressService.getAllCities();
        model.addAttribute("contractorTypes", contractorTypes);
        model.addAttribute("priceTypes",priceTypes);
        model.addAttribute("contractor", contractor);
        model.addAttribute("address", address);
        model.addAttribute("countries",countries);
        model.addAttribute("cities",cities);
        return "entire_contractor";
    }

    @PostMapping("/update")
    public String updateContractor(@ModelAttribute("contractor") ContractorUpdateCommand command) {
        Address address = addressService.findAddressByContractorId(command.getContractorId());
        addressService.updateAddressById(address.getAddressId(), command);
        contractorService.updateContractorById(command);
        return "redirect:/contractors/"+command.getContractorId();
    }
}
