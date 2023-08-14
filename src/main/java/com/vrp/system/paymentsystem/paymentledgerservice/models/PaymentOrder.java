package com.vrp.system.paymentsystem.paymentledgerservice.models;

public interface PaymentOrder {
    public String getSellername();
    public void setSellername(String sellername);
    public String getBuyername();
    public String getAmount();
    public void setAmount(String amount);
    public String getCurrencycode();
    public void setCurrencycode(String currencycode);
    public boolean isLedgerUpdated();
    public void setLedgerUpdated(boolean ledgerUpdated);
    public boolean isWalletUpdated();
    public void setWalletUpdated(boolean walletUpdated);


}
