package com.alibou.project2023TMA.controller;


import com.alibou.project2023TMA.Application;
import com.alibou.project2023TMA.entity.card;
import com.alibou.project2023TMA.entity.card_brand;
import com.alibou.project2023TMA.repository.cardRepository;
import com.alibou.project2023TMA.repository.card_brandRepository;
import com.alibou.project2023TMA.service.cardService;
import com.alibou.project2023TMA.service.categoryService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Data
@RestController
@RequestMapping("/card")
public class cardController {
    @Autowired
    private final cardRepository cardRepository;
    @Autowired
    private final cardService cardService;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    //Find All Card
    @GetMapping
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<List<card>> findAllCard() {
        logger.info("Find All Card Success");
        return ResponseEntity.ok(cardService.getAllCard());
    }

    //Find Card By ID
    @GetMapping("/{cardId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card> getCard(@PathVariable BigInteger cardId) {
        logger.info("Find Card Success");
        return ResponseEntity.ok((card) cardService.getCard(cardId));
    }

    //Create New Card
    @PostMapping
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card> saveCard(card card) {
        card savedCard = cardService.saveCard(card);
        logger.info("Create Card Success");
        return ResponseEntity.ok(savedCard);
    }

    //Delete Card
    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<card>> getCardNotDeleted() {
        List<card> notDeletedCards = cardService.getCardNotDeleted();
        logger.info("Delete Card Success");
        return ResponseEntity.ok(notDeletedCards);
    }

    //Update Card By ID
    @PutMapping("/{cardId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<card> updateCard(@PathVariable BigInteger cardId, @RequestParam Map<String, String> formData) {
        card updatedCardResult = cardService.updateCard(cardId, formData);
        if (updatedCardResult != null) {
            logger.info("Update Card Success");
            return ResponseEntity.ok(updatedCardResult);
        } else {
            logger.error("Can Find Card Update");
            return ResponseEntity.notFound().build();
        }
    }

    //Delete card
    @DeleteMapping("/{cardId}")
    @PreAuthorize("hasAnyRole('client_admin')")
    public ResponseEntity<List<card>> deleteCard(@PathVariable BigInteger cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok(cardService.getAllCard());
    }



}