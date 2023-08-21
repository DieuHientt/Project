package com.alibou.project2023TMA.service.Impl;


import com.alibou.project2023TMA.entity.wallet;
import com.alibou.project2023TMA.repository.walletRepository;
import com.alibou.project2023TMA.service.walletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
@Service
public class walletServiceImp implements walletService {
    private  walletRepository walletRepository;

    @Autowired
    public walletServiceImp(walletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<wallet> getAllWallet() {
        return walletRepository
                .findAll();
    }

    @Override
    public wallet saveWallet(wallet wallet) {
        walletRepository.save(wallet);
        return wallet;
    }

    @Override
    public Object getWallet(BigInteger walletId) {
        return walletRepository
                .findById(walletId)
                .orElse(null);
    }

    @Override
    public List<wallet> getWalletNotDeleted() {
        return walletRepository.findWalletNotDeleted();
    }
    @Override
    public wallet updateWallet(BigInteger walletId, Map<String, String> formData) {
        wallet existingWallet = walletRepository.findById(walletId).orElse(null);
        if (existingWallet != null) {
            String cash = formData.get("cash");
            String creadit = formData.get("creadit");
            String total = formData.get("total");
            String  keycloak_id = formData.get("keycloak_id");
            existingWallet.setCash(Integer.parseInt(cash));
            existingWallet.setCreadit(Integer.parseInt(creadit));
            existingWallet.setTotal(Integer.parseInt(total));
            existingWallet.setKeycloak_id(BigInteger.valueOf(Long.parseLong(keycloak_id)));
            String status = formData.get("status");
            existingWallet.setStatus(status);

            return walletRepository.save(existingWallet);
        }
        return null;
    }
}
