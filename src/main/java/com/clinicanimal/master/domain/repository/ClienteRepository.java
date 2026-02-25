package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByActiveTrue();
    Optional<Cliente> findByIdAndActiveTrue(Long id);

    @Query("SELECT c FROM Cliente c WHERE :nombre = '' OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) AND c.active = true ")
    List<Cliente> findAllByNombreFiltro(String nombre);
}

