package com.elsaber.service.impl;

import com.elsaber.dto.genero.GeneroRequestDto;
import com.elsaber.dto.genero.GeneroResponseDto;
import com.elsaber.entity.Genero;
import com.elsaber.mapper.GeneroMapper;
import com.elsaber.repository.IGeneroRepository;
import com.elsaber.service.IGeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements IGeneroService {
    private final IGeneroRepository repository;
    private final GeneroMapper generoMapper;

    @Override
    public List<GeneroResponseDto> listar() {
        return repository.findAll().stream()
                .map(generoMapper::toDo)
                .toList();
    }

    @Override
    public GeneroResponseDto agregarGenero(GeneroRequestDto requestDto) {
        Genero genero = generoMapper.toEntity(requestDto);
        return generoMapper.toDo(repository.save(genero));
    }

    @Override
    public GeneroResponseDto obtenerGenero(Long id) {
        return repository.findById(id)
                .map(generoMapper::toDo)
                .orElseThrow(() -> new RuntimeException("No se encontro el genero con el ID: " + id));
    }

    @Override
    public void eliminarGenero(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("No se encontro el genero con el ID: " + id);
        }
        repository.deleteById(id);
    }
}
