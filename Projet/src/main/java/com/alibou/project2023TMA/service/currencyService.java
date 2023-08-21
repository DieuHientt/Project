package com.alibou.project2023TMA.service;

import com.alibou.project2023TMA.entity.currency;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;


public interface currencyService {
    List<currency> getAllCurrency();
    currency saveCurrency(currency currency);

    Object getCurrency(BigInteger currencyId);

    List<currency> getCurrencyNotDeleted();

    currency updateCurrency(BigInteger currencyId, Map<String, String> formData);
}
