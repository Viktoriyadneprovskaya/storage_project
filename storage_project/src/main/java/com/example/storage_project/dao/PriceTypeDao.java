package com.example.storage_project.dao;

import com.example.storage_project.model.PriceType;

import java.util.List;

public interface PriceTypeDao {
    List<PriceType> getAllPriceTypes();
    PriceType getPriceTypeById(Long id);
}
