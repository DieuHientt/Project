package com.alibou.keycloak.controller;


import com.alibou.keycloak.model.card;
import com.alibou.keycloak.repository.cardRepository;
import com.alibou.keycloak.service.cardService;
import lombok.Data;
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


    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    List<card> getSubjects() {
        return cardRepository.findAll();
    }
}