package com.elsaber.mapper;

import com.elsaber.dto.autor.AutorRequestDto;
import com.elsaber.dto.autor.AutorResponseDto;
import com.elsaber.entity.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {
    public AutorResponseDto toDo(Autor autor) {
        return AutorResponseDto.builder()
                .id(autor.getId())
                .nomAutor(autor.getNomAutor())
                .build();
    }

    public Autor toEntity(AutorRequestDto requestDto) {
        return Autor.builder()
                .nomAutor(requestDto.getNomAutor())
                .build();
    }

    public Autor toEntityAutor(AutorResponseDto responseDto) {
        return Autor.builder()
                .id(responseDto.getId())
                .nomAutor(responseDto.getNomAutor())
                .build();
    }
}
