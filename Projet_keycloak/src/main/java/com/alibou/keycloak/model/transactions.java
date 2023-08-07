package com.alibou.keycloak.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "transactions")
public class transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger transaction_id;
    private int amount;
    private String note;
    @ManyToOne
    @JoinColumn(name = "card_id",nullable = false,referencedColumnName = "card_id")
    @JsonBackReference
    private card card;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transaction_categogy",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "categogy_id"))
    @JsonManagedReference
    private Set<category> category;

    @OneToMany(mappedBy = "transactions", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<income> income;

    @OneToMany(mappedBy = "transactions", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<outcome> outcome;

    @ManyToOne
    @JoinColumn(name = "wallet_id",nullable = false,referencedColumnName = "wallet_id")
    @JsonBackReference
    private wallet wallet;

}