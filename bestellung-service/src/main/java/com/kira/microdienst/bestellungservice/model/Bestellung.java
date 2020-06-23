package com.kira.microdienst.bestellungservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BESTELLUNG")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bestellung {
    @Id
    private Long id;
    private String name;
    private int menge;
    private double preis;

}
