package com.vrp.system.paymentsystem.paymentledgerservice.api;

import com.vrp.system.paymentsystem.paymentledgerservice.models.Order;
import com.vrp.system.paymentsystem.paymentledgerservice.service.LedgerEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainServiceEndpoint {
    @Autowired
    private LedgerEntryService service;

    @PostMapping("/api/v1/postOrder")
    public int postOrder( @RequestBody Order order){
           service.storeLedgerEntry(order);
           return 0;
    }
}
