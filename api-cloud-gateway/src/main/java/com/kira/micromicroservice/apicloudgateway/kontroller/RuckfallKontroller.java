package com.kira.micromicroservice.apicloudgateway.kontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RuckfallKontroller {
    @RequestMapping("/bestellungRuckfall")
    public Mono<String> bestellungServiceRückfall(){
        return Mono.just("Der Bestellung Server braucht lange zum Antworten oder ist ausgefallen. Bitte versuchen Sie es später noch einmal");
    }

    @RequestMapping("/bezahlungRuckfall")
    public Mono<String> bezahlungServiceRückfall(){
        return Mono.just("Der Bezahlung Server braucht lange zum Antworten oder ist ausgefallen. Bitte versuchen Sie es später noch einmal");
    }
}
