package com.example.warehouseproject.service.mapper;


import com.example.warehouseproject.domain.Client;
import com.example.warehouseproject.service.dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {

	default Client fromId(Long id) {
		if (id == null) {
			return null;
		}

		Client client = new Client();
		client.setId(id);
		return client;
	}
}
