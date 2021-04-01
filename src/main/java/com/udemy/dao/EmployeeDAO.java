package com.udemy.dao;

import com.udemy.dbEntity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
class EmployeeDAO implements DAO<Employee> {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<Employee> getDataFromDB(String sort) {
        session = sessionFactory.getCurrentSession ();
        Query<Employee> employeeQuery;
        if (sort.equalsIgnoreCase ("sortByFirstName" )) {
            employeeQuery = session.createQuery ("from Employee order by firstName");
        } else {
            employeeQuery =session.createQuery ( "from Employee order by lastName" );
        }
        return employeeQuery.getResultList ();
    }

    @Override
    public void save(Employee employee) {
        session = sessionFactory.getCurrentSession ();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getPerson(int id) {
        session = sessionFactory.getCurrentSession ();
        return session.get(Employee.class, id);
    }

    @Override
    public void delete(int id) {
        session = sessionFactory.getCurrentSession ();
        Query<Employee> employeeQuery = session.createQuery ( "delete Employee e where id=:employeeID");
        employeeQuery.setParameter ("employeeID", id).executeUpdate ();
        /*
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
       */
    }
}
