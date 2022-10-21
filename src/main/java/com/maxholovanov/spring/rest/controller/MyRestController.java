package com.maxholovanov.spring.rest.controller;

import com.maxholovanov.spring.rest.entity.Employee;
import com.maxholovanov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") //url любой команды будет содержать слово "api", -- это начало любой апи команды
public class MyRestController {
    //Работает с сервисом
    @Autowired
    private EmployeeService employeeService;

    //посылаем запрос get...
    //method для возвращения списка всех работников
    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }
}
