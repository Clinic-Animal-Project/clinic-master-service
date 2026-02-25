package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findAllByActiveTrue();
    Optional<Mascota> findByIdAndActiveTrue(Long id);
    List<Mascota> findAllByClienteIdAndActiveTrue(Long idCliente);

    @Query("SELECT m FROM Mascota m WHERE :nombre = '' OR LOWER(m.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) AND m.active = true ")
    List<Mascota> findAllByNombreFiltro(String nombre);
}

