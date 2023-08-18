package com.example.storage_project.dao.impl;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.command.employee.EmployeeUpdateCommand;
import com.example.storage_project.dao.employees.EmployeeDao;
import com.example.storage_project.model.employee.JobTitle;
import com.example.storage_project.model.security.Role;
import com.example.storage_project.service.JobTitleService;
import com.example.storage_project.service.RoleService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateEmployeeByPassword(String password, Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        employee.setPassword(password);
        transaction.commit();
        session.close();
    }

    @Override
    public Optional<Employee> findEmployeeByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query<Employee> query = session.createNamedQuery("Employee.findEmployeeByUserName", Employee.class);
        query.setParameter("username",username);
        Optional<Employee> employee = query.uniqueResultOptional();
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public List<Role> getAllRoles() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Role> query = session.createQuery("""
                select r from Role r
                """, Role.class);
        List<Role> roles = query.getResultList();
        transaction.commit();
        session.close();
        return roles;
    }

    @Override
    public Role getRoleById(Long roleId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.get(Role.class, roleId);
        transaction.commit();
        session.close();
        return role;
    }
}
