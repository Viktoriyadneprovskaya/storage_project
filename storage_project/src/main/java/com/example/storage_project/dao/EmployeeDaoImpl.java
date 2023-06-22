package com.example.storage_project.dao;
import com.example.storage_project.Employee;
import com.example.storage_project.command.EmployeeUpdateCommand;
import com.example.storage_project.dao.impl.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
    public void deleteEmployeeById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);//доработать валидацию на несуществующий id
        session.remove(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateEmployeeById(Long id, EmployeeUpdateCommand command) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);//доработать валидацию на несуществующий id
        employee.setFirstName(command.getFirstName());
        employee.setLastName(command.getLastname());
        employee.setJobTitle(command.getJobTitle());
        transaction.commit();
        session.close();
    }
}
