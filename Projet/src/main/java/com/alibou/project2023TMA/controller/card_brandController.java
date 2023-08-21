package com.alibou.project2023TMA.controller;

import com.alibou.project2023TMA.Application;
import com.alibou.project2023TMA.entity.card_brand;
import com.alibou.project2023TMA.service.card_brandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/card_brand")
public class card_brandController {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private  card_brandService card_brandService;

    //  Delete cardBrand
    @DeleteMapping("/{cardBrandId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<List<card_brand>> deleteCardBrand(@PathVariable BigInteger cardBrandId) {
        card_brandService.deleteCardBrand(cardBrandId);
        return ResponseEntity.ok(card_brandService.getAllCardBrand());
    }
    //Find All Card Brand
    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<card_brand>> findAllCardBrand() {
        logger.info("Find All Card Brand Success");
        return ResponseEntity.ok(card_brandService.getAllCardBrand());
    }
    //Find Card Brand By ID
    @GetMapping("/{cardBrandId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card_brand> getCardBrand(@PathVariable BigInteger cardBrandId) {
        logger.info("Find Card Brand Success");
        return ResponseEntity.ok((card_brand) card_brandService.getCardBrand(cardBrandId));
    }
    //Create New Card Brand
    @PostMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<card_brand> saveCardBrand(card_brand cardBrand) {
        card_brand savedCardBrand = card_brandService.saveCardBrand(cardBrand);
        logger.info("Create Card Brand Success");
        return ResponseEntity.ok(savedCardBrand);
    }
    //Delete Card Brand
    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('client_admin')")
    public List<card_brand> getCardBrandNotDeleted() {
        logger.info("Delete Card Brand Success");
        return card_brandService.getCardBrandNotDeleted();
    }
    //Update Card Brand By ID
    @PutMapping("/{cardBrandId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<card_brand> updateCardBrand(@PathVariable BigInteger cardBrandId, @RequestParam Map<String, String> formData) {
        card_brand updatedCardBrandResult = card_brandService.updateCardBrand(cardBrandId, formData);
        if (updatedCardBrandResult != null) {
            logger.info("Update Card Brand Success");
            return ResponseEntity.ok(updatedCardBrandResult);
        } else {
            logger.error("Can Find Brand Card Update");
            return ResponseEntity.notFound().build();
        }
    }
}