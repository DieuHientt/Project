package com.alibou.project2023TMA.service;



import com.alibou.project2023TMA.entity.transactions;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface transactionsService {
    List<transactions> getAllTransaction();
    transactions saveTransaction(transactions transactions);

    Object getTransaction(BigInteger transactionId);

    List<transactions> getTransactionNotDeleted();

    transactions updateTransaction(BigInteger transactionId, Map<String, String> formData);
}
//