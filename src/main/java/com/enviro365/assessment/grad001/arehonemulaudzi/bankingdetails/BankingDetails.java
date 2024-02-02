package com.enviro365.assessment.grad001.arehonemulaudzi.bankingdetails;

import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.WithdrawalNotice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

}
