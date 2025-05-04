package com.elsaber.mapper;

import com.elsaber.dto.genero.GeneroRequestDto;
import com.elsaber.dto.genero.GeneroResponseDto;
import com.elsaber.entity.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {
    public GeneroResponseDto toDo(Genero genero) {
        return GeneroResponseDto.builder()
                .id(genero.getId())
                .descripcion(genero.getDescripcion())
                .build();
    }

    public Genero toEntity(GeneroRequestDto requestDto) {
        return Genero.builder()
                .descripcion(requestDto.getDescripcion())
                .build();
    }

    public Genero toEntityGenero(GeneroResponseDto responseDto) {
        return Genero.builder()
                .id(responseDto.getId())
                .descripcion(responseDto.getDescripcion())
                .build();
    }
}
