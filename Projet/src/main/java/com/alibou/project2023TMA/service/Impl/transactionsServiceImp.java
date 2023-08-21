package com.alibou.project2023TMA.service.Impl;

import com.alibou.project2023TMA.entity.transactions;
import com.alibou.project2023TMA.repository.transactionRepository;
import com.alibou.project2023TMA.service.transactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
@Service
public class transactionsServiceImp implements transactionsService {
    private transactionRepository transactionRepository;
    @Autowired
    public transactionsServiceImp(transactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<transactions> getAllTransaction(){
        return transactionRepository
                .findAll();
    }

    @Override
    public transactions saveTransaction(transactions transactions) {
        transactionRepository.save(transactions);
        return transactions;
    }

    @Override
    public Object getTransaction(BigInteger transactionId) {
        return transactionRepository
                .findById(transactionId)
                .orElse(null);
    }

    @Override
    public List<transactions> getTransactionNotDeleted() {
        return transactionRepository.findTransactionNotDeleted();
    }
    @Override
    public transactions updateTransaction(BigInteger transactionId, Map<String, String> formData) {
        transactions existingTransaction = transactionRepository.findById(transactionId).orElse(null);
        if (existingTransaction != null) {
            String amount = formData.get("amount");
            String note = formData.get("note");
            existingTransaction.setAmount(Integer.parseInt(amount));
            existingTransaction.setNote(note);
            String status = formData.get("status");
            existingTransaction.setStatus(status);
            return transactionRepository.save(existingTransaction);
        }
        return null;
    }
}
