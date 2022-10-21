package com.maxholovanov.spring.rest.controller;

import com.maxholovanov.spring.rest.entity.Employee;
import com.maxholovanov.spring.rest.exception.EmployeeIncorrectData;
import com.maxholovanov.spring.rest.exception.NoSuchEmployeeException;
import com.maxholovanov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                   id + " in Database");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in DataBase");
        }

        employeeService.deleteInfo(id);

        return "Employee with ID = " + id + " was deleted";
    }

}
