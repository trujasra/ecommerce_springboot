package com.postgrado.ecommerce.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "{product.name.not-blank}" )
    @Size(max = 70, min = 3, message = "{product.name.size}")
    private String name;
    @NotBlank(message = "{product.description.not-blank}")
    private String description;
    @URL
    private String imageUrl;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "{product.price.min}")
    private double price;
    @NotNull
    @Min(value = 0, message = "{product.stock.min}")
    private int stock;
    @NotNull
    private boolean active;
    @NotNull
    private UUID categoryId;
}

