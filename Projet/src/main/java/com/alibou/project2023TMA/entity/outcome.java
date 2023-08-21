package com.alibou.project2023TMA.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "outcome")
public class outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger outcome_id;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
    private Date date_time;
    private String status;
    @ManyToOne ( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id")
    @JsonManagedReference
    private transactions transactions;
}