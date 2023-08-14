package com.vrp.system.paymentsystem.paymentledgerservice.dao;

import com.vrp.system.paymentsystem.paymentledgerservice.models.LedgerEntry;
import org.springframework.data.repository.CrudRepository;

public interface LedgerEntryDao extends CrudRepository<LedgerEntry,Long> {
}
