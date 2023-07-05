package com.example.storage_project.service;

import com.example.storage_project.dao.JobTitleDao;
import com.example.storage_project.model.JobTitle;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobTitleService {
    private final JobTitleDao jobTitleDao;

    public JobTitleService(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }


    public List<JobTitle> getAllJobTitles() {
        return jobTitleDao.getAllJobTitles();
    }
    public JobTitle getJobTitleById(Long id){
        return jobTitleDao.getJobTitleById(id);
    }
}
