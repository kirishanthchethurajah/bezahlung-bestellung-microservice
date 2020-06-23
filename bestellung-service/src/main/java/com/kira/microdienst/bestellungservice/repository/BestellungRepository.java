package com.kira.microdienst.bestellungservice.repository;

import com.kira.microdienst.bestellungservice.model.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {
}
