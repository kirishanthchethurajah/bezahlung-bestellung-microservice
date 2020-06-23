package com.kira.microdienst.bezahlungservice.kontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kira.microdienst.bezahlungservice.model.Bezahlung;
import com.kira.microdienst.bezahlungservice.service.BezahlungService;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/bezahlung")
public class BezahlungKontroller {
    private BezahlungService bezahlungService;

    public BezahlungKontroller(BezahlungService bezahlungService) {
        this.bezahlungService = bezahlungService;
    }

    @PostMapping("/machenBezahlung")
    public Bezahlung machenBezahlung(@RequestBody Bezahlung bezahlung){

        try {
            return bezahlungService.machenBezahlung(bezahlung);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{bestellungId}")
    public Bezahlung findenBezahlungByBestellungId(@PathVariable  Long bestellungId){
        try {
            return  bezahlungService.findenBezahlungByBestellungId(bestellungId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
