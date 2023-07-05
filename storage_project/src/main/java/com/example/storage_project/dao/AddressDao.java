package com.example.storage_project.dao;

import com.example.storage_project.command.AddressUpdateCommand;
import com.example.storage_project.model.Address;
import com.example.storage_project.model.City;
import com.example.storage_project.model.Country;

import java.util.List;

public interface AddressDao {
    void saveAddress(Address address);
    Address getAddressById(Long id);
    void deleteAddressById(Long id);
    void updateAddressById(Long id, AddressUpdateCommand command);
    List<Address> findAddressesByContractorId(Long id);
    List<Country> getAllCountries();
    List<City> getAllCities();
    Country getCountryById(Long id);
    City getCityById(Long id);


}
