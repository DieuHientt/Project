package com.alibou.project2023TMA.controller;


import com.alibou.project2023TMA.Application;
import com.alibou.project2023TMA.entity.outcome;
import com.alibou.project2023TMA.service.outcomeService;
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
@RequestMapping("/outcome")
public class outcomeController {
    @Autowired
    private outcomeService outcomeService;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    //Find All Outcome
    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<outcome>> findAllOutcome() {
        logger.info("Find All Outcome Success");
        return ResponseEntity.ok(outcomeService.getAllOutcome());
    }
    //Find Outcome By ID
    @GetMapping("/{outcomeId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<outcome> getOutcome(@PathVariable BigInteger outcomeId) {
        logger.info("Find Outcome Success");
        return ResponseEntity.ok((outcome) outcomeService.getOutcome(outcomeId));
    }
    //Create New Outcome
    @PostMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<outcome> saveOutcome(outcome outcome) {
        outcome savedOutcome = outcomeService.saveOutcome(outcome);
        logger.info("Create Outcome Success");
        return ResponseEntity.ok(savedOutcome);
    }
    //Delete Outcome
    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<outcome>> getOutcomeNotDeleted() {
        List<outcome> notDeletedOutcome = outcomeService.getOutcomeNotDeleted();
        logger.info("Delete Outcome Success");
        return ResponseEntity.ok(notDeletedOutcome);
    }
    //Update Outcome By ID
    @PutMapping("/{outcomeId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<outcome> updateOutcome(@PathVariable BigInteger outcomeId, @RequestParam Map<String, String> formData) {
        outcome updatedOutcomeResult =outcomeService.updateOutcome(outcomeId, formData);
        if (updatedOutcomeResult != null) {
            logger.info("Update Outcome Success");
            return ResponseEntity.ok(updatedOutcomeResult);
        } else {
            logger.error("Can Find Outcome Update");
            return ResponseEntity.notFound().build();
        }
    }


}
