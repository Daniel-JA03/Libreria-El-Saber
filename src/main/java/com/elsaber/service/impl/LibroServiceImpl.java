package com.elsaber.service.impl;

import com.elsaber.dto.autor.AutorResponseDto;
import com.elsaber.dto.genero.GeneroResponseDto;
import com.elsaber.dto.libro.LibroRequestDto;
import com.elsaber.dto.libro.LibroResponseDto;
import com.elsaber.entity.Autor;
import com.elsaber.entity.Genero;
import com.elsaber.entity.Libro;
import com.elsaber.mapper.AutorMapper;
import com.elsaber.mapper.GeneroMapper;
import com.elsaber.mapper.LibroMapper;
import com.elsaber.repository.ILibroRepository;
import com.elsaber.service.IAutorService;
import com.elsaber.service.IGeneroService;
import com.elsaber.service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements ILibroService {
    private final ILibroRepository repository;
    private final LibroMapper libroMapper;

    private final IAutorService autorService;
    private final AutorMapper autorMapper;

    private final IGeneroService generoService;
    private final GeneroMapper generoMapper;

    @Override
    public List<LibroResponseDto> listar() {
        return repository.findAll().stream()
                .map(libroMapper::toDo)
                .toList();
    }

    @Override
    public LibroResponseDto registrarLibro(LibroRequestDto requestDto) {
        AutorResponseDto autorResponseDto = autorService.obtenerAutor(requestDto.getAutorId());
        Autor autor = autorMapper.toEntityAutor(autorResponseDto);
        GeneroResponseDto generoResponseDto = generoService.obtenerGenero(requestDto.getGeneroId());
        Genero genero = generoMapper.toEntityGenero(generoResponseDto);
        Libro libro = libroMapper.toEntity(requestDto, autor, genero);
        return libroMapper.toDo(repository.save(libro));
    }

    @Override
    public LibroResponseDto listarLibroPorId(Long id) {
        return repository.findById(id)
                .map(libroMapper::toDo)
                .orElseThrow(() -> new RuntimeException("No se encontro el Libro con el ID: " + id));
    }

    @Override
    public void eliminarLibroLogicamente(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No se encontro el libro con el ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<LibroResponseDto> listarLibrosConPrecioMayorA(BigDecimal precio) {
        return repository.findByPrecioLibroGreaterThan(precio).stream()
                .map(libroMapper::toDo)
                .toList();
    }
}
