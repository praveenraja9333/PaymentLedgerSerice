package com.vrp.system.paymentsystem.paymentledgerservice.service;

import com.vrp.system.paymentsystem.paymentledgerservice.dao.LedgerEntryDao;
import com.vrp.system.paymentsystem.paymentledgerservice.models.LedgerEntry;
import com.vrp.system.paymentsystem.paymentledgerservice.models.Order;
import com.vrp.system.paymentsystem.paymentledgerservice.models.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

@Component
public class LedgerEntryService {
    private static NumberFormat currencyFormatter=NumberFormat.getNumberInstance();

    @Autowired
    private LedgerEntryDao ledgerEntryDao;
    public int storeLedgerEntry(Order order){
        List<PaymentOrder> paymentOrderList=order.getPaymentOrderList();
        paymentOrderList.stream().forEach(po-> {
            try {
                LedgerEntry debitledgerEntry = LedgerEntry.newBuilder().setCheckoutId(order.getCheckoutid()).setUserInfo(order.getBuyerinfo())
                        .setDebit(currencyFormatter.parse(po.getAmount()).doubleValue()).setCredit(0.0).build();
                LedgerEntry creditledgerEntry = LedgerEntry.newBuilder().setCheckoutId(order.getCheckoutid()).setUserInfo(order.getBuyerinfo())
                        .setDebit(0.0)
                        .setCredit(currencyFormatter.parse(po.getAmount()).doubleValue())
                        .build();
                ledgerEntryDao.save(debitledgerEntry);
                ledgerEntryDao.save(creditledgerEntry);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        });
        return 0;
    }
    
}
