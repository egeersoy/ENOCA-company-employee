package com.example.demo.payloads;

import com.example.demo.model.Company;
import lombok.Data;

import java.util.UUID;

@Data
public class NewEmployeeRequest {
    private String name;
    private UUID companyId;

}
