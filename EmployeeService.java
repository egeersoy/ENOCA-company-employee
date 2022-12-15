package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.payloads.NewEmployeeRequest;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(NewEmployeeRequest employeeRequest) {
        Company company = companyRepository.findById(employeeRequest.getCompanyId()).get();
        final var newEmployee = new Employee();
        newEmployee.setName(employeeRequest.getName());
        newEmployee.setCreateDate(new Date());
        company.getEmployees().add(newEmployee);
        companyRepository.save(company);
        return newEmployee;
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeesbById(UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
