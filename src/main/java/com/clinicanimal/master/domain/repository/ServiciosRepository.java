package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
    List<Servicios> findAllByActiveTrue();
    Optional<Servicios> findByIdAndActiveTrue(Long id);
}
