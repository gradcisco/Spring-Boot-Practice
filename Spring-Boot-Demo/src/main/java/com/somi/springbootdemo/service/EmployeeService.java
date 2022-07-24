package com.somi.springbootdemo.service;

import com.somi.springbootdemo.model.Employee;
import com.somi.springbootdemo.repository.EmployeeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee getEmployee(Long id);

    public void saveEmployee(Employee emp);

    public void deleteEmployee(Long id);

    public Employee update(Long id, Employee emp);
}
