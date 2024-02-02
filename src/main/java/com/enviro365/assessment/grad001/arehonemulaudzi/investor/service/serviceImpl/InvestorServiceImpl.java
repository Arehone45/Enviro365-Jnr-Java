package com.enviro365.assessment.grad001.arehonemulaudzi.investor.service.serviceImpl;

import com.enviro365.assessment.grad001.arehonemulaudzi.investor.Investor;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto.InvestorRequest;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.dto.InvestorResponse;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.exceptions.InvestorException;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.repository.InvestorRepository;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.service.InvestorService;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.dto.ProductRequest;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvestorServiceImpl implements InvestorService {

    private final InvestorRepository investorRepository;
    private final ProductRepository productRepository;

    //This module adds the investor details
    @Override
    public InvestorResponse saveInvestor(InvestorRequest investorRequest) {

        Investor investor = Investor.builder()
                .firstName(investorRequest.getFirstName())
                .lastName(investorRequest.getLastName())
                .age(investorRequest.getAge())
                .idNumber(investorRequest.getIdNumber())
                .address(investorRequest.getAddress())
                .contactNo(investorRequest.getContactNo())
                .build();

        investor = investorRepository.save(investor);

        InvestorResponse investorResponse = new InvestorResponse();

        BeanUtils.copyProperties(investor, investorResponse);

        return investorResponse;

    }

    @Override
    public InvestorResponse getInvestorById(Long investorId) {

        Investor investor = investorRepository.findById(investorId)
                .orElseThrow(() -> new InvestorException("Investor with id: " + investorId + " not found."));

        InvestorResponse investorResponse = new InvestorResponse();

        BeanUtils.copyProperties(investor, investorResponse);

        return investorResponse;
    }

    @Override
    public Investor addProductsToInvestor(List<ProductRequest> productRequest, Long investorId) {

        InvestorResponse investorResponse = getInvestorById(investorId);
        Investor investor = new Investor();

        BeanUtils.copyProperties(investorResponse, investor);


        List<Product> products = productRequest.stream()
                .map(request -> Product.builder()
                        .productName(request.getProductName())
                        .productType(request.getProductType())
                        .currentBalance(request.getCurrentBalance())
                        .investor(investor)
                        .build())
                .toList();
        products.forEach(productRepository::save);

        investor.setProducts(products);
        investorRepository.save(investor);

        return investor;
    }

    public Investor findInvestorById(Long investorId) {

        return investorRepository.findById(investorId)
                .orElseThrow(() -> new InvestorException("Investor not found"));
    }
}
