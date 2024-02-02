package com.enviro365.assessment.grad001.arehonemulaudzi.investor.controller;

import com.enviro365.assessment.grad001.arehonemulaudzi.investor.Investor;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto.InvestorRequest;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto.InvestorResponse;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.service.serviceImpl.InvestorServiceImpl;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investor")
@RequiredArgsConstructor
public class InvestorController {

    private final InvestorServiceImpl investorService;

    @PostMapping("/addInvestor")
    public InvestorResponse addInvestor(@RequestBody InvestorRequest investorRequest) {

        return investorService.saveInvestor(investorRequest);
    }

    @GetMapping("/getInvestorById/{investorId}")
    public InvestorResponse getInvestorById(@PathVariable Long investorId) {
        return investorService.getInvestorById(investorId);
    }

    @GetMapping("/findInvestorById/{investorId}")
    public Investor findInvestorById(@PathVariable Long investorId) {
        return investorService.findInvestorById(investorId);
    }
    @PostMapping("/addProducts/{investorId}")
    public Investor addProducts(@RequestBody List<ProductRequest> products , @PathVariable Long investorId) {

        return investorService.addProductsToInvestor(products, investorId);
    }
}
