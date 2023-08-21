package com.alibou.project2023TMA.service.Impl;

import com.alibou.project2023TMA.entity.currency;
import com.alibou.project2023TMA.repository.currencyRepository;
import com.alibou.project2023TMA.service.currencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class currencyServiceImp  implements currencyService {
    private currencyRepository currencyRepository;

    @Autowired
    public currencyServiceImp(currencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<currency> getAllCurrency() {
        return currencyRepository
                .findAll();
    }

    @Override
    public currency saveCurrency(currency currency) {
        currencyRepository.save(currency);
        return currency;
    }

    @Override
    public Object getCurrency(BigInteger currencyId) {
        return currencyRepository
                .findById(currencyId)
                .orElse(null);
    }

    @Override
    public List<currency> getCurrencyNotDeleted() {
        return currencyRepository.findCurrencyNotDeleted();
    }
    @Override
    public currency updateCurrency(BigInteger currencyId, Map<String, String> formData) {
        currency existingCurrency = currencyRepository.findById(currencyId).orElse(null);
        if (existingCurrency != null) {
            String name_currency = formData.get("name_currency");
            existingCurrency.setName_currency(name_currency);
            String status = formData.get("status");
            existingCurrency.setStatus(status);
            return currencyRepository.save(existingCurrency);
        }
        return null;
    }
}