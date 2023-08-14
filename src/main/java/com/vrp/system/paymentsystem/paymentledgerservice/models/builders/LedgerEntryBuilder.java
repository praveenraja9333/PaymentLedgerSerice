package com.vrp.system.paymentsystem.paymentledgerservice.models.builders;

import com.vrp.system.paymentsystem.paymentledgerservice.models.LedgerEntry;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class LedgerEntryBuilder extends Builder<LedgerEntry> {

    private UUID checkoutId;
    private String userinfo;
    private double debit;
    private double credit;

    public LedgerEntryBuilder setCheckoutId(UUID checkoutId){
        this.checkoutId=checkoutId;
        return self();
    }

    public LedgerEntryBuilder setUserInfo(String userinfo){
        this.userinfo=userinfo;
        return self();
    }
    public LedgerEntryBuilder setDebit(double debit){
        this.debit=debit;
        return self();
    }

    public LedgerEntryBuilder setCredit(double credit){
        this.credit=credit;
        return self();
    }

    public LedgerEntryBuilder self(){
        return this;
    }

    @Override
    public LedgerEntry build() {
        LedgerEntry ledgerEntry=new LedgerEntry();
        ledgerEntry.setCheckoutId(requireNonNull(this.checkoutId));
        ledgerEntry.setUserinfo(requireNonNull(this.userinfo));
        ledgerEntry.setCredit(this.credit);
        ledgerEntry.setDebit(this.debit);
        return ledgerEntry;
    }
}
