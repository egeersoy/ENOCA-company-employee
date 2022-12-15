package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService CompanyService;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanys() {


        return new ResponseEntity<>(CompanyService.getCompanys(), HttpStatus.OK);
}
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable UUID id) {
        Company result = getCompanyById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company newCompany) {
        return new ResponseEntity<>(CompanyService.createCompany(newCompany), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getCompany(@PathVariable UUID id, @RequestBody Company newCompany) {
        Company oldCompany = getCompanyById(id);
        oldCompany.setName(newCompany.getName());
        oldCompany.setCreateDate(new Date());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable UUID id) {
        CompanyService.deleteCompany(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Company getCompanyById(UUID id) {
      return   CompanyService.getCompanysbById(id);

    }
}
