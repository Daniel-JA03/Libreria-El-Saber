package com.elsaber.controller;

import com.elsaber.dto.genero.GeneroRequestDto;
import com.elsaber.dto.genero.GeneroResponseDto;
import com.elsaber.service.IGeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
@RequiredArgsConstructor
public class GeneroController {
    private final IGeneroService service;

    @GetMapping
    public List<GeneroResponseDto> listar() {
        return service.listar();
    }

    @PostMapping
    public GeneroResponseDto agregarGenero(@RequestBody GeneroRequestDto requestDto) {
        return service.agregarGenero(requestDto);
    }

    @GetMapping("/{id}")
    public GeneroResponseDto obtenerGenero(@PathVariable Long id) {
        return service.obtenerGenero(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable Long id) {
        service.eliminarGenero(id);
    }
}
