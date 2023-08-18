package com.example.simplecrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplecrud.entity.Employee;
import com.example.simplecrud.service.EmployeeService;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	  @Autowired
	    private EmployeeService employeeService;

	    @PostMapping
	    public String saveEmployee(@RequestBody Employee employee) {
	        Optional<Employee> _employee = employeeService.create(employee);
	        if(_employee.isPresent()){
	            return "The employee data has been saved successfully!";
	        }else{
	            return "Employee already exist in records";
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
	      Optional<Employee> employee = employeeService.retrieveOne(id);  
	      if (employee.isPresent()) {
	        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }    

	    @GetMapping
	    public List<Employee> getALLEmployees() {
	      return employeeService.retrieve();
	    }

	    @PutMapping
	    public String updateEmployee(@RequestBody Employee employee) {
	        Optional<Employee> _employee = employeeService.update(employee);
	        if(_employee.isEmpty()){
	            return "The employee data does not exist in records!";
	        }else{
	            return "The employee data has been updated successfully!";
	        }
	    }

	    @DeleteMapping("/{id}")
	    public String deleteEmployeeById(@PathVariable("id") int id) {
	      return  employeeService.delete(id);   
	    } 

}
