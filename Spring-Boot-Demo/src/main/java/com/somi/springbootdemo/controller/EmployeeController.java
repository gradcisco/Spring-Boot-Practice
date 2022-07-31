package com.somi.springbootdemo.controller;

import com.somi.springbootdemo.model.Employee;
import com.somi.springbootdemo.service.EmployeeService;
import com.somi.springbootdemo.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
       return new ResponseEntity<List<Employee>>(employeeService.getEmployees(),HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<HttpStatus> saveEmployee(@RequestBody Employee emp){

        System.out.println("\n\n" + emp + "\n\n");
        logger.info(emp.toString() + "Saved successfully");
        employeeService.saveEmployee(emp);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestParam Long id, @RequestBody Employee emp){

        employeeService.update(id,emp);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
}
