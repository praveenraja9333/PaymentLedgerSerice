package com.vrp.system.paymentsystem.paymentledgerservice.api;

import com.vrp.system.paymentsystem.paymentledgerservice.models.Order;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainServiceEndpoint {

    @PostMapping("/api/v1/postOrder")
    public int postOrder( @RequestBody Order order){

           return 0;
    }
}
