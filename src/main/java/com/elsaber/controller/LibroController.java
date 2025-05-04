package com.elsaber.controller;

import com.elsaber.dto.libro.LibroRequestDto;
import com.elsaber.dto.libro.LibroResponseDto;
import com.elsaber.service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/libro")
@RequiredArgsConstructor
public class LibroController {
    private final ILibroService service;

    @GetMapping
    public List<LibroResponseDto> listar() {
        return service.listar();
    }

    @PostMapping
    public LibroResponseDto agregarLibro(@RequestBody LibroRequestDto requestDto) {
        return service.registrarLibro(requestDto);
    }

    @GetMapping("/{id}")
    public LibroResponseDto obtenerLibro(@PathVariable Long id) {
        return service.listarLibroPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        service.eliminarLibroLogicamente(id);
    }

    @GetMapping("/precio/{precio}")
    public List<LibroResponseDto> listarLibrosConPrecioMayorA(@PathVariable BigDecimal precio) {
        return service.listarLibrosConPrecioMayorA(precio);
    }
}
