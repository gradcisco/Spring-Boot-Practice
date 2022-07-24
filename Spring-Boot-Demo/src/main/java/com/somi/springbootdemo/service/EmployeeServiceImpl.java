package com.somi.springbootdemo.service;

import com.somi.springbootdemo.model.Employee;
import com.somi.springbootdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> res = employeeRepo.findAll();
        System.out.println("res::" + res);
        return res;
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);

        if(emp.isPresent())
            return emp.get();
        throw new RuntimeException("Employeed with id " + id + " not found");
    }

    @Override
    public void saveEmployee(Employee emp) {

        employeeRepo.save(emp);

    }

    @Override
    public void deleteEmployee(Long id) {
          employeeRepo.deleteById(id);
    }

    @Override
    public Employee update(Long id, Employee emp) {
        return employeeRepo.save(emp);
    }
}
