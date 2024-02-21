package com.enviro365.assessment.grad001.arehonemulaudzi.bankingdetails;

import com.enviro365.assessment.grad001.arehonemulaudzi.investor.Investor;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.WithdrawalNotice;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Builder
public class BankingDetails {

    @Id
    @GeneratedValue
    private long id;
    private String accountHolderName;
    private String bankName;
    private String accountNumber;
    @OneToOne
    @JoinColumn(name = "withdrawalNotice_id")
    @JsonBackReference
    private WithdrawalNotice withdrawalNotice;

}
