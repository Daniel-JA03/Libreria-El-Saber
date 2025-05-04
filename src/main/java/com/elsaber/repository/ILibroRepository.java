package com.elsaber.repository;

import com.elsaber.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ILibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByPrecioLibroGreaterThan(BigDecimal precio);
}
