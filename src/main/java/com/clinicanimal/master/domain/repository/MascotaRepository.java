package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findAllByActiveTrue();
    Optional<Mascota> findByIdAndActiveTrue(Long id);
}

