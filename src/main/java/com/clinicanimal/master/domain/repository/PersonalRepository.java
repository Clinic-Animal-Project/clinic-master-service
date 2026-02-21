package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    List<Personal> findAllByActiveTrue();
    Optional<Personal> findByIdAndActiveTrue(Long id);
}
