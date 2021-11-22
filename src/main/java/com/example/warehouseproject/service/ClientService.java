package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Client;
import com.example.warehouseproject.repository.ClientRepository;
import com.example.warehouseproject.service.dto.ClientDTO;
import com.example.warehouseproject.service.mapper.ClientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDTO save(ClientDTO clientDTO) {
        if (clientDTO.getId() == null) {
            Client client = clientMapper.toEntity(clientDTO);
            client = clientRepository.save(client);
            return clientMapper.toDto(client);
        }
        return null;
    }

    public ClientDTO update(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.findByClientId(client.getId());
        if (client.getId() != null) {
            client.setName(client.getName());
            client.setPhoneNumber(client.getPhoneNumber());
            client = clientRepository.save(client);
            return clientMapper.toDto(client);
        }
        return null;
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toDto);
    }

    public Optional<ClientDTO> findOne(Long id) {
        if (id == null) {
            return null;
        }
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
