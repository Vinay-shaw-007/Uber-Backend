package com.vinay.project.uber.uberApp.services;

import com.vinay.project.uber.uberApp.dto.WalletTransactionDto;
import com.vinay.project.uber.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
