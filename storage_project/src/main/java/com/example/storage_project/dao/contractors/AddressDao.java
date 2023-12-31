package com.example.storage_project.dao.contractors;
import com.example.storage_project.command.contractor.ContractorUpdateCommand;
import com.example.storage_project.model.contractor.Address;
import com.example.storage_project.model.contractor.City;
import com.example.storage_project.model.contractor.Country;

import java.util.List;

public interface AddressDao {
    void saveAddress(Address address);
    void updateAddressById(Long id, ContractorUpdateCommand command);
    Address findAddressByContractorId(Long id);
    List<Country> getAllCountries();
    List<City> getAllCities();
    Country getCountryById(Long id);
    City getCityById(Long id);


}
