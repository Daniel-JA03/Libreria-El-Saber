package com.elsaber.service;

import com.elsaber.dto.genero.GeneroRequestDto;
import com.elsaber.dto.genero.GeneroResponseDto;

import java.util.List;

public interface IGeneroService {
    List<GeneroResponseDto> listar();
    GeneroResponseDto agregarGenero(GeneroRequestDto requestDto);
    GeneroResponseDto obtenerGenero(Long id);
    void eliminarGenero(Long id);
}
