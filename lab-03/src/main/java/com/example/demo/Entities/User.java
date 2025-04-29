package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String phoneNumber;
    private Double walletBalance = 0.0;

    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<Transaction> sentTransactions;

    @OneToMany(mappedBy = "receiver")
    @JsonIgnore
    private List<Transaction> receivedTransactions;





}
