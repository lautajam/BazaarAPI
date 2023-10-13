package com.lautajam.BazaarAPI.repository;

import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
