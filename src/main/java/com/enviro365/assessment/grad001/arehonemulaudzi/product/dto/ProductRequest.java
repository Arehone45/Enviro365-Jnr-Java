package com.enviro365.assessment.grad001.arehonemulaudzi.product.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequest {

    private String productName;
    private double currentBalance;
}
