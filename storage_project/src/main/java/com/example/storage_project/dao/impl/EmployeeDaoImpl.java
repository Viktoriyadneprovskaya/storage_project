package com.example.storage_project.dao.impl;
import com.example.storage_project.model.Employee;
import com.example.storage_project.command.EmployeeUpdateCommand;
import com.example.storage_project.dao.EmployeeDao;
import com.example.storage_project.model.JobTitle;
import com.example.storage_project.service.JobTitleService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;
    private final JobTitleService jobTitleService;


    public EmployeeDaoImpl(SessionFactory sessionFactory, JobTitleService jobTitleService) {
        this.sessionFactory = sessionFactory;
        this.jobTitleService = jobTitleService;
    }
    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Employee> query = session.createQuery("""
                select e from Employee e
                join fetch e.jobTitle
                """, Employee.class);
        List<Employee> employees = query.getResultList();
        transaction.commit();
        session.close();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateEmployeeById(EmployeeUpdateCommand command) {
        JobTitle jobTitle = jobTitleService.getJobTitleById(command.getJobTitle());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, command.getId());
        employee.setUsername(command.getUsername());
        employee.setFirstName(command.getFirstName());
        employee.setLastName(command.getLastName());
        employee.setJobTitle(jobTitle);
        transaction.commit();
        session.close();
    }

}
