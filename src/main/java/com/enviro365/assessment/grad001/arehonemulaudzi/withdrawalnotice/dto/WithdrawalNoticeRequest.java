package com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.dto;

import com.enviro365.assessment.grad001.arehonemulaudzi.bankingdetails.BankingDetails;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.ProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class WithdrawalNoticeRequest {

    private String productName;
    private double withdrawalAmount;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private LocalDate date;
    private BankingDetails bankingDetails;
}
