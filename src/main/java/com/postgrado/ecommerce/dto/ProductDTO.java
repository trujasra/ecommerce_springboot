package com.postgrado.ecommerce.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "The product name can not be blank")
    @Size(max = 70, min = 3, message = "The product name must to between 3 and 70")
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private int stock;
    private boolean active;
    private UUID categoryId;
}

