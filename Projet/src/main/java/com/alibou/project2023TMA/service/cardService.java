package com.alibou.project2023TMA.service;

import com.alibou.project2023TMA.entity.card;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
@Service
public interface cardService {

    List<card> getAllCard();
    card saveCard(card card);
    Object getCard(BigInteger cardId);
    void deleteCard(BigInteger cardId);
    card updateCard(BigInteger cardId, Map<String, String> formData);
    List<card> getCardNotDeleted();
}
