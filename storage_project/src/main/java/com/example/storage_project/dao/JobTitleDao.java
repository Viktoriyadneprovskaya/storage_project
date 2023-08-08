package com.example.storage_project.dao;

import com.example.storage_project.model.employee.JobTitle;

import java.util.List;

public interface JobTitleDao {
    List<JobTitle> getAllJobTitles();
    JobTitle getJobTitleById(Long id);
}
