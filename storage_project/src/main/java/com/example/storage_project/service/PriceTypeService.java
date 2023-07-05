package com.example.storage_project.service;

import com.example.storage_project.dao.PriceTypeDao;
import com.example.storage_project.model.PriceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceTypeService {
    private final PriceTypeDao priceTypeDao;

    public PriceTypeService(PriceTypeDao priceTypeDao) {
        this.priceTypeDao = priceTypeDao;
    }

    public List<PriceType> getAllPriceTypes(){
        return priceTypeDao.getAllPriceTypes();
    }
    public PriceType getPriceTypeById(Long id){
        return priceTypeDao.getPriceTypeById(id);
    }
}
