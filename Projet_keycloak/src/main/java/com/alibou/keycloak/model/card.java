package com.alibou.keycloak.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "card")
public class card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger card_id;
    private int amount;
    private String card_number;
    private String symbol;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private card_brand cardBrand;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<transactions> transactions;

}