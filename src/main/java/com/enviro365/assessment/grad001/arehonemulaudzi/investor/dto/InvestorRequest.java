package com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvestorRequest {

    private String firstName;
    private String lastName;
    private int age;
    private String idNumber;
    private String address;
    private String contactNo;
}
