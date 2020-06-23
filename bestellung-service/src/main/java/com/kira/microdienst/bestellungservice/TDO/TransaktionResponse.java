package com.kira.microdienst.bestellungservice.TDO;

import com.kira.microdienst.bestellungservice.model.Bestellung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaktionResponse {
    private Bestellung bestellung;
    private double preis;
    private String transaktionId;
    private String msg;


}
