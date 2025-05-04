package com.elsaber.mapper;

import com.elsaber.dto.libro.LibroRequestDto;
import com.elsaber.dto.libro.LibroResponseDto;
import com.elsaber.entity.Autor;
import com.elsaber.entity.Genero;
import com.elsaber.entity.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {
    public LibroResponseDto toDo(Libro libro) {
        return LibroResponseDto.builder()
                .id(libro.getId())
                .titLibro(libro.getTitLibro())
                .autorId(libro.getAutor().getId())
                .nomAutor(libro.getAutor().getNomAutor())
                .generoId(libro.getGenero().getId())
                .descripcion(libro.getGenero().getDescripcion())
                .precioLibro(libro.getPrecioLibro())
                .estado(libro.getEstado())
                .build();
    }

    public Libro toEntity(LibroRequestDto requestDto, Autor autor, Genero genero) {
        return Libro.builder()
                .titLibro(requestDto.getTitLibro())
                .autor(autor)
                .genero(genero)
                .precioLibro(requestDto.getPrecioLibro())
                .estado(requestDto.getEstado())
                .build();
    }
}
