package com.elsaber.service.impl;

import com.elsaber.dto.autor.AutorRequestDto;
import com.elsaber.dto.autor.AutorResponseDto;
import com.elsaber.entity.Autor;
import com.elsaber.mapper.AutorMapper;
import com.elsaber.repository.IAutorRepository;
import com.elsaber.service.IAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements IAutorService {
    private final IAutorRepository repository;
    private final AutorMapper autorMapper;

    @Override
    public List<AutorResponseDto> listar() {
        return repository.findAll().stream()
                .map(autorMapper::toDo)
                .toList();
    }

    @Override
    public AutorResponseDto agregarAutor(AutorRequestDto requestDto) {
        Autor autor = autorMapper.toEntity(requestDto);
        return autorMapper.toDo(repository.save(autor));
    }

    @Override
    public AutorResponseDto obtenerAutor(Long id) {
        return repository.findById(id)
                .map(autorMapper::toDo)
                .orElseThrow(() -> new RuntimeException("No se encontro el autor con el ID: " + id));
    }

    @Override
    public void eliminarAutor(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("No se encontro el autor con el ID:" + id);
        }
        repository.deleteById(id);
    }
}
