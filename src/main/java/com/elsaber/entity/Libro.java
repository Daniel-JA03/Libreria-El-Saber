package com.elsaber.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_libro")
    private Long id;
    @Column(name = "tit_libro", length = 200, nullable = false)
    private String titLibro;
    @ManyToOne
    @JoinColumn(name = "cod_autor", nullable = false)
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "cod_genero", nullable = false)
    private Genero genero;
    @Column(name = "precio_libro", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioLibro;
    @Column(length = 200, nullable = false)
    private String estado;
}
