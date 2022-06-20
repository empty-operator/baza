package com.baza.service.impl;

import com.baza.entity.Tariff;
import com.baza.repository.TariffRepository;
import com.baza.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TariffServiceImpl implements TariffService {

    private final TariffRepository repository;

    @Override
    public List<Tariff> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Tariff tariff) {
        repository.save(tariff);
    }

    @Override
    public Optional<Tariff> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Tariff getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

}
