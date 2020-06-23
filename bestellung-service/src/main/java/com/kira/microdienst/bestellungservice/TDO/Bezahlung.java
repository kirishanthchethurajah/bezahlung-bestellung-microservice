package com.kira.microdienst.bestellungservice.TDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bezahlung {
    private Long bezahlungId;
    private String bezahlungStatus;
    private String transaktionId;
    private Long bestellungId;
    private double preis;

}
