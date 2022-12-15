package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.payloads.NewEmployeeRequest;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {


        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
}
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID id) {
        Employee result = getEmployeeById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody NewEmployeeRequest newEmployee) {
        return new ResponseEntity<>(employeeService.createEmployee(newEmployee), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getEmployee(@PathVariable UUID id, @RequestBody Employee newEmployee) {
        Employee oldEmployee = getEmployeeById(id);
        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setCreateDate(new Date());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Employee getEmployeeById(UUID id) {
      return   employeeService.getEmployeesbById(id);

    }
}
