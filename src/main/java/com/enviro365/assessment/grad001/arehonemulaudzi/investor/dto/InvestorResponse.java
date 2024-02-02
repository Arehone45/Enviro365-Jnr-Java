package com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InvestorResponse {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String idNumber;
    private String address;
    private String contactNo;
}
