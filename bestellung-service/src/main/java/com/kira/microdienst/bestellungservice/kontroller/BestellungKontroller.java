package com.kira.microdienst.bestellungservice.kontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kira.microdienst.bestellungservice.TDO.Bezahlung;
import com.kira.microdienst.bestellungservice.TDO.TransaktionRequest;
import com.kira.microdienst.bestellungservice.TDO.TransaktionResponse;
import com.kira.microdienst.bestellungservice.model.Bestellung;
import com.kira.microdienst.bestellungservice.service.BestellungService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bestellung")
public class BestellungKontroller {
    private BestellungService bestellungService;

    public BestellungKontroller(BestellungService bestellungService) {
        this.bestellungService = bestellungService;
    }

    @PostMapping("/buchBestellung")
    public TransaktionResponse reservierenBestellung(@RequestBody TransaktionRequest transaktionRequest){

        try {
            return bestellungService.speichernBestellung(transaktionRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
