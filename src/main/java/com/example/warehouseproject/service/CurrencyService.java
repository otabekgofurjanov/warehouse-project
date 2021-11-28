package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Currency;
import com.example.warehouseproject.repository.CurrencyRepository;
import com.example.warehouseproject.service.dto.CurrencyDTO;
import com.example.warehouseproject.service.mapper.CurrencyMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public CurrencyService(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    public CurrencyDTO save(CurrencyDTO currencyDTO) {
        if (currencyDTO.getId() == null) {
            Currency currency = currencyMapper.toEntity(currencyDTO);
            currency = currencyRepository.save(currency);
            return currencyMapper.toDto(currency);
        }
        return null;
    }

    public CurrencyDTO update(CurrencyDTO currencyDTO) {
        Currency currency = currencyMapper.toEntity(currencyDTO);
        currency = currencyRepository.findCurrencyById(currency.getId());
        if (currency.getId() != null) {
            currency.setName(currency.getName());
            currency.setActive(currency.isActive());
            currency = currencyRepository.save(currency);
            return currencyMapper.toDto(currency);
        }
        return null;
    }

    public Page<CurrencyDTO> getAll(Pageable pageable) {
        return currencyRepository.findAll(pageable).map(currencyMapper::toDto);
    }

    public Optional<CurrencyDTO> findOne(Long id) {
        if (id == null) {
            return null;
        }
        return currencyRepository.findById(id).map(currencyMapper::toDto);
    }

    public void delete(Long id) {
        currencyRepository.deleteById(id);
    }


}
