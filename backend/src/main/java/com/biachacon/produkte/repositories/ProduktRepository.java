package com.biachacon.produkte.repositories;

import com.biachacon.produkte.models.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktRepository extends JpaRepository<Produkt, Long> {

    Produkt findById(long id);

}
