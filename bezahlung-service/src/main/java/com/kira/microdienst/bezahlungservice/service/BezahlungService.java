package com.kira.microdienst.bezahlungservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kira.microdienst.bezahlungservice.model.Bezahlung;
import com.kira.microdienst.bezahlungservice.repository.BezahlungRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Random;
import java.util.UUID;

@Service
public class BezahlungService {
    private BezahlungRepository bezahlungRepository;

    private static final Logger log = LoggerFactory.getLogger(BezahlungService.class);


    public BezahlungService(BezahlungRepository bezahlungRepository) {
        this.bezahlungRepository = bezahlungRepository;
    }

    public Bezahlung machenBezahlung(Bezahlung bezahlung) throws JsonProcessingException {
        bezahlung.setTransaktionId(UUID.randomUUID().toString());
        bezahlung.setBezahlungStatus(ZahlungVerarbeitung());
        log.info("BezahlungService request: {}",new ObjectMapper().writeValueAsString(bezahlung));

        return bezahlungRepository.save(bezahlung);

    }

    public String ZahlungVerarbeitung(){
        return new Random().nextBoolean()?"erfolg":"scheitern";
    }

    public Bezahlung findenBezahlungByBestellungId(Long bestellungId) throws JsonProcessingException {
        Bezahlung erhalteBezahlung = bezahlungRepository.findByBestellungId(bestellungId);
        log.info("BezahlungService findenBezahlungByBestellungId: {}",new ObjectMapper().writeValueAsString(erhalteBezahlung));

        return erhalteBezahlung;
    }
}
