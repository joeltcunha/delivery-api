package com.deliverytech.delivery_api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


public class ClienteDto {
    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "\\d{10,11}")
    private String telefone;

    @NotBlank
    private String endereco;

    

}
