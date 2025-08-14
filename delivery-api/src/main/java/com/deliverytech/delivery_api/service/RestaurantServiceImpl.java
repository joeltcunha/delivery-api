package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.RestaurantDto;
import com.deliverytech.delivery_api.entity.Restaurant;
import com.deliverytech.delivery_api.repository.IRestaurantRepository;

@Service
public class RestaurantServiceImpl {
    @Autowired
    private IRestaurantRepository repository;
    public RestaurantServiceImpl(IRestaurantRepository restaurantRepository) {
        this.repository = restaurantRepository;
    }
    public RestaurantServiceImpl() {
        super();
    }

    public List<RestaurantDto> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDTO).collect(Collectors.toList());
    }

    private RestaurantDto ConvertEntityToDTO(Restaurant entity)
    {
        RestaurantDto dto = new RestaurantDto();
        dto.setName(entity.getNome());
        dto.setDescription((entity.getDescricao()));
        dto.setAddress(entity.getEndereco());
        return dto;
    }

}
