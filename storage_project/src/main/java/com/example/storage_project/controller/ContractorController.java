package com.example.storage_project.controller;

import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.model.Address;
import com.example.storage_project.model.ContractorType;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.PriceType;
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
        List<ContractorType> contractorTypes = contractorTypeService.getAllContractorTypes();
        List<PriceType> priceTypes = priceTypeService.getAllPriceTypes();
        model.addAttribute("contractors", contractors);
        model.addAttribute("contractorTypes", contractorTypes);
        model.addAttribute("priceTypes",priceTypes);
        return "contractors";
    }


    @GetMapping("/delete")
    public String deleteContractor(@RequestParam("id") Long id, @RequestParam("contrTypeId") Long contrTypeId) {
        contractorService.deleteContractorById(id);
        return "redirect:/contractors?contrTypeId=" + contrTypeId;
    }

    @GetMapping("/{contractor_id}")
    public String getAllAddressesByContractorId(Model model, @PathVariable Long contractor_id) {
        Contractors contractor = contractorService.getContractorById(contractor_id);
        List<Address> addresses = addressService.findAddressesByContractorId(contractor_id);
        model.addAttribute("contractor", contractor);
        model.addAttribute("addresses", addresses);
        return "/contractors-address";
    }
    @GetMapping("/delete-address")
    public String deleteAddress(@RequestParam("id") Long id,@RequestParam("contractor_id") Long contractor_id) {
        addressService.deleteAddressById(id);
        return "redirect:"+contractor_id;
    }

    @PostMapping("/update")
    public String updateContractor(@ModelAttribute("contractor") ContractorUpdateCommand command) {
        contractorService.updateContractorById(command);
        return "redirect:/contractors?contrTypeId=" + command.getContractorType();
    }

//    @PostMapping("/update-address")
//    public String updateAddressByContractor(){
//
//    }
}
