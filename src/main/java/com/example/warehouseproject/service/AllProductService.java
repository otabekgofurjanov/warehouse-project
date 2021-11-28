package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.AllProduct;
import com.example.warehouseproject.repository.AllProductRepository;
import com.example.warehouseproject.service.dto.AllProductDTO;
import com.example.warehouseproject.service.mapper.AllProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AllProductService {

    private final AllProductRepository allProductRepository;
    private final AllProductMapper allProductMapper;

    public AllProductService(AllProductRepository allProductRepository, AllProductMapper allProductMapper) {
        this.allProductRepository = allProductRepository;
        this.allProductMapper = allProductMapper;
    }

    public AllProductDTO save(AllProductDTO allProductDTO) {
        AllProduct allProduct = allProductMapper.toEntity(allProductDTO);
        allProduct = allProductRepository.save(allProduct);
        return allProductMapper.toDto(allProduct);
    }

    public AllProductDTO update(AllProductDTO allProductDTO) {
        AllProduct allProduct = allProductMapper.toEntity(allProductDTO);
        allProduct = allProductRepository.findAllProductById(allProduct.getId());
        if (allProduct.getId() != null) {
            allProduct.setProduct(allProduct.getProduct());
            allProduct.setActive(allProduct.getActive());
            allProduct.setAmount(allProduct.getAmount());
            allProduct.setDate(allProduct.getDate());
            allProduct = allProductRepository.save(allProduct);
            return allProductMapper.toDto(allProduct);

        }
        return null;
    }

    public Page<AllProductDTO> findAll(Pageable pageable) {
        return allProductRepository.findAll(pageable).map(allProductMapper::toDto);
    }

    public Optional<AllProductDTO> findOne(Long id) {
        return allProductRepository.findById(id).map(allProductMapper::toDto);
    }

    public void delete(Long id) {
        allProductRepository.deleteById(id);
    }
}
