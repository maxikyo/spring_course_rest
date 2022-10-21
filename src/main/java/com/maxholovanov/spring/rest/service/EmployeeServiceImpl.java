package com.maxholovanov.spring.rest.service;

import com.maxholovanov.spring.rest.dao.EmployeeDAO;
import com.maxholovanov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Перенаправляет всю работу в репозиторий employeeDAO, а тот в свою очередть работает с базой данынх
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteInfo(int id) {
        employeeDAO.deleteInfo(id);
    }
}
