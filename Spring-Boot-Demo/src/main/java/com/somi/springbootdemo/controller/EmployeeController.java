package com.somi.springbootdemo.controller;

import com.somi.springbootdemo.model.Employee;
import com.somi.springbootdemo.service.EmployeeService;
import com.somi.springbootdemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

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

        employeeService.saveEmployee(emp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathParam("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestParam Long id, @RequestBody Employee emp){

        employeeService.update(id,emp);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
}
