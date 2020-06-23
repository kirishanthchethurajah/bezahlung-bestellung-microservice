package com.kira.microdienst.bestellungservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kira.microdienst.bestellungservice.TDO.Bezahlung;
import com.kira.microdienst.bestellungservice.TDO.TransaktionRequest;
import com.kira.microdienst.bestellungservice.TDO.TransaktionResponse;
import com.kira.microdienst.bestellungservice.kontroller.BestellungKontroller;
import com.kira.microdienst.bestellungservice.model.Bestellung;
import com.kira.microdienst.bestellungservice.repository.BestellungRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RefreshScope
public class BestellungService {
    private BestellungRepository bestellungRepository;
    @Lazy
    private RestTemplate restTemplate;
    @Value("${microservice.bezahlung-service.endpoints.endpoint.uri}")
    private String bezahlung_URL;

    private static final Logger log = LoggerFactory.getLogger(BestellungService.class);


    public BestellungService(BestellungRepository bestellungRepository, RestTemplate restTemplate) {
        this.bestellungRepository = bestellungRepository;
        this.restTemplate = restTemplate;
    }

    public TransaktionResponse speichernBestellung(TransaktionRequest transaktionRequest) throws JsonProcessingException {
        Bestellung bestellung = transaktionRequest.getBestellung();
        Bezahlung bezahlung = transaktionRequest.getBezahlung();
        bezahlung.setPreis(bestellung.getPreis());
        bezahlung.setBestellungId(bestellung.getId());
        System.out.println(bezahlung.getPreis());

        Bezahlung speichernBezahlung = restTemplate.postForObject(bezahlung_URL,bezahlung,Bezahlung.class);
        String response = speichernBezahlung.getBezahlungStatus().equals("erfolg")?"erfolg":"scheitern";
        bestellungRepository.save(bestellung);
        log.info("BestellungService request: {}",new ObjectMapper().writeValueAsString(transaktionRequest));
        log.info("BezahlungService response: {}",new ObjectMapper().writeValueAsString(response));


        return new TransaktionResponse(bestellung, speichernBezahlung.getPreis(), speichernBezahlung.getTransaktionId(), response ) ;
    }
}
