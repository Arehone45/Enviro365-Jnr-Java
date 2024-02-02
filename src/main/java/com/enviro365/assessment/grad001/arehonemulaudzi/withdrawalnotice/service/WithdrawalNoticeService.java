package com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.service;

import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.WithdrawalNotice;
import com.enviro365.assessment.grad001.arehonemulaudzi.withdrawalnotice.dto.WithdrawalNoticeRequest;

public interface WithdrawalNoticeService {

    WithdrawalNotice createWithdrawalNotice(Long investorId, WithdrawalNoticeRequest withdrawalNoticeRequest);
}
