package com.example.storage_project.dao;

import com.example.storage_project.model.Employee;
import com.example.storage_project.model.MeasureUnit;

import java.util.List;
import java.util.Optional;

public interface MeasureUnitDao {
    MeasureUnit getMeasureUnitById(Long id);
    List<MeasureUnit> getAllMeasureUnits();
}
