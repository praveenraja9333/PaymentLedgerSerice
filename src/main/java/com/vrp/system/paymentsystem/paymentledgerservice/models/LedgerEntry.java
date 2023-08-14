package com.vrp.system.paymentsystem.paymentledgerservice.models;


import com.vrp.system.paymentsystem.paymentledgerservice.models.builders.LedgerEntryBuilder;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Transactional
@Table(name="DoubleLedgerEntry")
public class LedgerEntry {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column
    private UUID checkoutId;

    @Column
    @NotNull(message="userinfo should not be null")
    @NotBlank(message="Blank object are not allowed for userinfo, Should be a valid name or id of the user")
    private String userinfo;

    @Column
    private double debit;
    @Column
    private double credit;

    public UUID getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(UUID checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public static LedgerEntryBuilder newBuilder(){
        return new LedgerEntryBuilder();
    }
}
