package com.enviro365.assessment.grad001.arehonemulaudzi.product;

import com.enviro365.assessment.grad001.arehonemulaudzi.investor.Investor;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.WithdrawalNotice;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productName;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private double currentBalance;
    @ManyToOne
    @JoinColumn(name = "investor_id")
    @JsonBackReference
    private Investor investor;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<WithdrawalNotice> withdrawalNotices;

}
