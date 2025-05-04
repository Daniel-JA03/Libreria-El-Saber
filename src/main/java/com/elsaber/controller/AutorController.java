package com.elsaber.controller;

import com.elsaber.dto.autor.AutorRequestDto;
import com.elsaber.dto.autor.AutorResponseDto;
import com.elsaber.service.IAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autor")
@RequiredArgsConstructor
public class AutorController {
    private final IAutorService service;

    @GetMapping
    public List<AutorResponseDto> listar() {
        return service.listar();
    }

    @PostMapping
    public AutorResponseDto agregarAutor(@RequestBody AutorRequestDto requestDto) {
        return service.agregarAutor(requestDto);
    }

    @GetMapping("/{id}")
    public AutorResponseDto obtenerAutor(@PathVariable Long id) {
        return service.obtenerAutor(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        service.eliminarAutor(id);
    }
}
