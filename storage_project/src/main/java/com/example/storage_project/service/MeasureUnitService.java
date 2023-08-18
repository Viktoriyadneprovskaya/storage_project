package com.example.storage_project.service;

import com.example.storage_project.dao.documents.MeasureUnitDao;
import com.example.storage_project.model.product.MeasureUnit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureUnitService {
    private  final MeasureUnitDao measureUnitDao;

    public MeasureUnitService(MeasureUnitDao measureUnitDao) {
        this.measureUnitDao = measureUnitDao;
    }
    public MeasureUnit getMeasureUnitById(Long id){
        return measureUnitDao.getMeasureUnitById(id);
    }
    public List<MeasureUnit> getAllMeasureUnits(){
        return measureUnitDao.getAllMeasureUnits();
    }
}
