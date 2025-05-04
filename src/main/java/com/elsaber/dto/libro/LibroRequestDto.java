package com.elsaber.dto.libro;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LibroRequestDto {
    private String titLibro;
    private Long autorId;
    private Long generoId;
    private BigDecimal precioLibro;
    private String estado;
}
