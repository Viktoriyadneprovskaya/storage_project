package com.example.storage_project.dao.documents;

import com.example.storage_project.model.product.PriceType;

import java.util.List;

public interface PriceTypeDao {
    List<PriceType> getAllPriceTypes();
    PriceType getPriceTypeById(Long id);
}
