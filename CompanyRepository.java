package com.example.demo.repository;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.rmi.server.UID;
import java.util.UUID;

public interface CompanyRepository extends MongoRepository<Company, UUID> {
}
