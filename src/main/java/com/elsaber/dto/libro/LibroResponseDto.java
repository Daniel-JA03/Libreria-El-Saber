package com.elsaber.dto.libro;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LibroResponseDto {
    private Long id;
    private String titLibro;
    private Long autorId;
    private String nomAutor;
    private Long generoId;
    private String descripcion;
    private BigDecimal precioLibro;
    private String estado;
}
