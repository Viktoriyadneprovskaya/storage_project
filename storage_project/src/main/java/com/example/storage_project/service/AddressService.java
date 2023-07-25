package com.example.storage_project.service;

import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.AddressDao;
import com.example.storage_project.model.Address;
import com.example.storage_project.model.City;
import com.example.storage_project.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {
    private final AddressDao addressDao;

    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void saveAddress(Address address){
        addressDao.saveAddress(address);
    }
    public void deleteAddressById(Long id){
        addressDao.deleteAddressById(id);
    }
    public void updateAddressById(Long id, ContractorUpdateCommand command){
        addressDao.updateAddressById(id,command);
    }
    public Address findAddressByContractorId(Long id){
        Address address=addressDao.findAddressByContractorId(id);
        return address;
    }
    public Address getAddressById(Long id) {
        return addressDao.getAddressById(id);
    }
    public List<Country> getAllCountries() {
        return addressDao.getAllCountries();
    }
    public List<City> getAllCities() {
        return addressDao.getAllCities();
    }
    public Country getCountryById(Long id){
        return addressDao.getCountryById(id);
    }
    public City getCityById(Long id){
        return addressDao.getCityById(id);
    }
}
