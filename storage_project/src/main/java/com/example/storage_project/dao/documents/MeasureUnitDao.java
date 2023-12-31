package com.example.storage_project.dao.documents;

import com.example.storage_project.model.product.MeasureUnit;

import java.util.List;

public interface MeasureUnitDao {
    MeasureUnit getMeasureUnitById(Long id);
    List<MeasureUnit> getAllMeasureUnits();
}
