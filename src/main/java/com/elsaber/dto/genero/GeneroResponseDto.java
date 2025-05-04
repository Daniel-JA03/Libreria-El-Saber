package com.elsaber.dto.genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneroResponseDto {
    private Long id;
    private String descripcion;
}
