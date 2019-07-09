package com.example.primenumber.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "requests")
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    private String timestamp;

    @Column(nullable = false)
    private int lowerLimit;

    @Column(nullable = false)
    private int upperLimit;

    @JsonIgnore
    private long timeElapsed;

    private String algorithmType;

    @JsonIgnore
    private int numberOfPrimes;




}
