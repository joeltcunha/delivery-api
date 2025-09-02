package com.deliverytech.delivery_api.dto;

import com.deliverytech.delivery_api.entity.UserRole;

import lombok.Data;


public record RegisterDto(String login, String password, UserRole role) {

}
