package com.example.project2023.model;


import javax.persistence.*;


import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "wallet")
public class wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wallet_id;
    @Column(name = "cash", nullable = false)
    private int cash;
    @Column(name = "creadit", nullable = false)
    private double creadit;
    @Column(name = "total", nullable = false)
    private double total;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

            @JoinTable(name = "wallet_currency",
            joinColumns = { @JoinColumn(name = "wallet_id") },
            inverseJoinColumns = { @JoinColumn(name = "currency_id") })
    private Collection<currency> currency;
}
