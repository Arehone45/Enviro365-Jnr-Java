package com.enviro365.assessment.grad001.arehonemulaudzi.investor.service;

import com.enviro365.assessment.grad001.arehonemulaudzi.investor.Investor;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto.InvestorRequest;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto.InvestorResponse;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.dto.ProductRequest;

import java.util.List;

public interface InvestorService {

    InvestorResponse saveInvestor(InvestorRequest investorRequest);
    InvestorResponse getInvestorById(Long investorId);
    Investor addProductsToInvestor(List<ProductRequest> product, Long investorId);
}
