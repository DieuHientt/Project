package com.alibou.keycloak.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "income")
public class income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger income_id;
    private Date date_time;

    @ManyToOne
    @JoinColumn(name = "transaction_id",nullable = false,referencedColumnName = "transaction_id")
    @JsonBackReference
    private transactions transactions;
}