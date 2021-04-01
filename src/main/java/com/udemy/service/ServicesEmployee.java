package com.udemy.service;

import com.udemy.dao.DAO;
import com.udemy.dbEntity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class ServicesEmployee implements Services <Employee> {
    @Autowired
    private DAO<Employee> employeeDAO;

    @Override
    @Transactional
    public List<Employee> getServicesList(String sort) {
        return employeeDAO.getDataFromDB (sort);
    }

    @Override
    @Transactional
    public void saveFromServices(Employee employee) {
        employeeDAO.save (employee);
    }

    @Override
    @Transactional
    public Employee getFromServices(int id) {
        return employeeDAO.getPerson (id);
    }

    @Override
    @Transactional
    public void deleteFromServices(int id) {
        employeeDAO.delete (id);
    }
}
