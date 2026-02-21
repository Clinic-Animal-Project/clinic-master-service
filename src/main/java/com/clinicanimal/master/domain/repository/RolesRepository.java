package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    List<Roles> findAllByActiveTrue();
    Optional<Roles> findByIdAndActiveTrue(Long id);
}
