package com.example.storage_project.controller;

import com.example.storage_project.command.ContractorCommand;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.model.Address;
import com.example.storage_project.model.ContractorType;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.service.AddressService;
import com.example.storage_project.service.ContractorService;
import com.example.storage_project.service.ContractorTypeService;
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

    public ContractorController(ContractorService contractorService, AddressService addressService, ContractorTypeService contractorTypeService) {
        this.contractorService = contractorService;
        this.addressService = addressService;
        this.contractorTypeService = contractorTypeService;
    }

    @GetMapping
    public String getAllContractors(Model model, @RequestParam("contrTypeId") Long contrTypeId) {
        List<Contractors> contractors = contractorService.getAllContractors(contrTypeId);
        model.addAttribute("contractors", contractors);
        return "contractors";
    }


    @GetMapping("/delete")
    public String deleteContractor(@RequestParam("id") Long id, @RequestParam("contrTypeId") Long contrTypeId) {
        contractorService.deleteContractorById(id);
        return "redirect:/contractors?contrTypeId=" + contrTypeId;
        //?contrTypeId=" + contrTypeId;
    }

    @GetMapping("/{contractor_id}")
    public String getAllAddressesByContractorId(Model model, @PathVariable Long contractor_id) {
        Contractors contractor = contractorService.getContractorById(contractor_id);
        List<Address> addresses = addressService.findAddressesByContractorId(contractor_id);
        model.addAttribute("contractor", contractor);
        model.addAttribute("addresses", addresses);
        return "/contractors-address";
    }

    //need to check
    @GetMapping("/delete-address")
    public String deleteAddress(@RequestParam("id") Long id) {
        addressService.deleteAddressById(id);
        return "redirect:/contractors-address";
    }

    @PostMapping("/update")
    public String updateContractor(@ModelAttribute("contractor") Contractors contractor) {
        ContractorUpdateCommand command = ContractorUpdateCommand.builder()
                .code(contractor.getCode())
                .contractorName(contractor.getContractorName())
                .contractNumber(contractor.getContractNumber())
                .contractorType(contractor.getContractorType())
                .priceType(contractor.getPriceType())
                .build();
        contractorService.updateContractorById(contractor.getContractorId(), command);
        return "redirect:/contractors";
    }
}
