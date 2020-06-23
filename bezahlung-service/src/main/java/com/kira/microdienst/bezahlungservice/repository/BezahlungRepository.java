package com.kira.microdienst.bezahlungservice.repository;

import com.kira.microdienst.bezahlungservice.model.Bezahlung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BezahlungRepository extends JpaRepository<Bezahlung, Long> {
    Bezahlung findByBestellungId(Long bestellungId);
}
