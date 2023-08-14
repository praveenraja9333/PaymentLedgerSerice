package com.vrp.system.paymentsystem.paymentledgerservice.models;

import java.util.List;
import java.util.UUID;

public interface Order {
    public UUID getCheckoutid();
    public void setCheckoutid(UUID checkoutid);
    public String getBuyerinfo();
    public void setBuyerinfo(String buyerinfo);
    public String getCurrencycode();
    public void setCurrencycode(String currencycode);
    public boolean isStatus();
    public void setStatus(boolean status);
    public List<PaymentOrder> getPaymentOrderList();
    public void setPaymentOrderList(List<PaymentOrder> paymentOrderList);

}
