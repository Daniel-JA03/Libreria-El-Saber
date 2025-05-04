package com.elsaber.service;

import com.elsaber.dto.autor.AutorRequestDto;
import com.elsaber.dto.autor.AutorResponseDto;

import java.util.List;

public interface IAutorService {
    List<AutorResponseDto> listar();
    AutorResponseDto agregarAutor(AutorRequestDto requestDto);
    AutorResponseDto obtenerAutor(Long id);
    void eliminarAutor(Long id);
}
