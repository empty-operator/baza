package com.baza.service;

import com.baza.entity.Tariff;

import java.util.List;
import java.util.Optional;

public interface TariffService {
    List<Tariff> findAll();

    void save(Tariff tariff);

    Optional<Tariff> findById(Long id);

    void deleteById(Long id);

    Tariff getReferenceById(Long id);
}
