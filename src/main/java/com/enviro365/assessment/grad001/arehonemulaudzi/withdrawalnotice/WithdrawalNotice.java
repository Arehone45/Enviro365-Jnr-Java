package com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice;

import com.enviro365.assessment.grad001.arehonemulaudzi.bankingdetails.BankingDetails;
import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double withdrawalAmount;
    private LocalDate date = LocalDate.now();
    @ManyToOne()
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    @OneToOne(mappedBy = "withdrawalNotice", cascade = CascadeType.ALL)
    @JsonManagedReference
    private BankingDetails bankingDetails;

}
