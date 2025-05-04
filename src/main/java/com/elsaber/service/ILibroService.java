package com.elsaber.service;

import com.elsaber.dto.libro.LibroRequestDto;
import com.elsaber.dto.libro.LibroResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ILibroService {
    List<LibroResponseDto> listar();
    LibroResponseDto registrarLibro(LibroRequestDto requestDto);
    LibroResponseDto listarLibroPorId(Long id);
    void eliminarLibroLogicamente(Long id);
    List<LibroResponseDto> listarLibrosConPrecioMayorA(BigDecimal precio);
}
