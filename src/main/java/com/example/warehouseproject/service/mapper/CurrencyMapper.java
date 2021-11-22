package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Currency;
import com.example.warehouseproject.service.dto.CurrencyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CurrencyMapper extends EntityMapper<CurrencyDTO, Currency> {

	default Currency fromId(Long id) {
		if (id == null) {
			return null;
		}

		Currency currency = new Currency();
		currency.setId(id);
		return currency;
	}
}
