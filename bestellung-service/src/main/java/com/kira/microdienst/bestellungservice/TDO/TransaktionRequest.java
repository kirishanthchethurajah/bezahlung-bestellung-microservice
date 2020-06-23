package com.kira.microdienst.bestellungservice.TDO;

import com.kira.microdienst.bestellungservice.model.Bestellung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransaktionRequest {
    private Bestellung bestellung;
    private Bezahlung bezahlung;
}
