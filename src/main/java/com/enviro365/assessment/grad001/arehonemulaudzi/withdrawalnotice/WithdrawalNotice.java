package com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice;

import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double withdrawalAmount;
    private LocalDate date = LocalDate.now();
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

}
