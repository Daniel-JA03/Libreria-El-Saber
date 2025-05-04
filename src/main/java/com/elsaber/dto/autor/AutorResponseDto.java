package com.elsaber.dto.autor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutorResponseDto {
    private Long id;
    private String nomAutor;
}
