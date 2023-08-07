package com.example.project2023.model;



import javax.persistence.*;
import lombok.*;
import java.util.Collection;


@Data
@Getter
@Setter
@Entity
@Table(name = "currency")
public class currency  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int currency_id;

    @Column(name = "name_currency", nullable = false)
    private String name_currency;

    @ManyToMany(mappedBy = "wallet")
    private Collection<wallet> wallet;
}
