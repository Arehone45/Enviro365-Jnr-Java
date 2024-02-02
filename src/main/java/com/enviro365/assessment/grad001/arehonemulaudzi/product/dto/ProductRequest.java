package com.enviro365.assessment.grad001.arehonemulaudzi.product.dto;

import com.enviro365.assessment.grad001.arehonemulaudzi.product.ProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequest {

    private String productName;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private double currentBalance;
}
