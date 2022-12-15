package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository CompanyRepository;
    public List<Company> getCompanys() {
        return CompanyRepository.findAll();
    }

    public Company createCompany(Company newCompany) {
        newCompany.setCreateDate(new Date());
        return CompanyRepository.save(newCompany);
    }

    public void deleteCompany(UUID id) {
        CompanyRepository.deleteById(id);
    }

    public Company getCompanysbById(UUID id) {
        return CompanyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }
}
