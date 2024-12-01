package com.vinay.project.uber.uberApp.strategies.impl;

import com.vinay.project.uber.uberApp.entities.Driver;
import com.vinay.project.uber.uberApp.entities.Payment;
import com.vinay.project.uber.uberApp.entities.enums.PaymentStatus;
import com.vinay.project.uber.uberApp.entities.enums.TransactionMethod;
import com.vinay.project.uber.uberApp.repositories.PaymentRepository;
import com.vinay.project.uber.uberApp.services.PaymentService;
import com.vinay.project.uber.uberApp.services.WalletService;
import com.vinay.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider -> 100
//Driver -> Deduct Rs.30 from Driver's wallet


@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;


    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount()*PLATFORM_COMMISSION;

        walletService.deductMoneyToWallet(driver.getUser(), platformCommission, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);

        paymentRepository.save(payment);
    }
}
//10 ratingCount = 4.0
//new rating 4.6
//updated rating
//new rating 44.6/11=4.05