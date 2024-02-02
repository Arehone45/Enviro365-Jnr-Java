package com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.service.serviceImpl;

import com.enviro365.assessment.grad001.arehonemulaudzi.investor.Investor;
import com.enviro365.assessment.grad001.arehonemulaudzi.investor.repository.InvestorRepository;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.ProductType;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.repository.ProductRepository;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.WithdrawalNotice;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.dto.WithdrawalNoticeRequest;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.repository.WithdrawalNoticeRepository;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.service.WithdrawalNoticeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService {

    private final InvestorRepository investorRepository;
    private final ProductRepository productRepository;
    private final WithdrawalNoticeRepository withdrawalNoticeRepository;

    @Override
    public WithdrawalNotice createWithdrawalNotice(Long investorId, WithdrawalNoticeRequest withdrawalNoticeRequest) {

        Investor investor = investorRepository.findById(investorId)
                .orElseThrow(() -> new RuntimeException("Investor not found"));


        Product withdrawProduct = productRepository.findByProductName(withdrawalNoticeRequest.getProductName());


        if (withdrawProduct != null && withdrawProduct.getCurrentBalance() > 0.9*(withdrawalNoticeRequest.getWithdrawalAmount())) {

            if (withdrawProduct.getProductType().equals(ProductType.RETIREMENT) && investor.getAge() > 65) {

                WithdrawalNotice withdrawalNotice = WithdrawalNotice.builder()
                        .withdrawalAmount(withdrawalNoticeRequest.getWithdrawalAmount())
                        .date(LocalDate.now())
                        .product(withdrawProduct)
                        //.bankingDetails(withdrawalNoticeRequest.getBankingDetails())
                        .build();


                //withdrawalNotice.setProduct(withdrawProduct);
                withdrawalNotice = withdrawalNoticeRepository.save(withdrawalNotice);

                return withdrawalNotice;
            } else if (withdrawProduct.getProductType().equals(ProductType.RETIREMENT) && investor.getAge() < 65){

                throw new RuntimeException("Age to withdraw for retirement should be > 65");

            }
                WithdrawalNotice withdrawalNotice = WithdrawalNotice.builder()
                        .withdrawalAmount(withdrawalNoticeRequest.getWithdrawalAmount())
                        .date(LocalDate.now())
                        .build();

                withdrawalNotice.setProduct(withdrawProduct);
                withdrawalNotice = withdrawalNoticeRepository.save(withdrawalNotice);

                return withdrawalNotice;
            }
        else {
            throw new RuntimeException("Product not found or withdrawal amount > 90% of the current balance.");
        }

    }
}
