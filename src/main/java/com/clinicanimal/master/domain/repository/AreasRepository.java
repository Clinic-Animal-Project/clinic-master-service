package com.clinicanimal.master.domain.repository;

import com.clinicanimal.master.domain.model.Areas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AreasRepository extends JpaRepository<Areas, Long> {
    List<Areas> findAllByActiveTrue();
    Optional<Areas> findByIdAndActiveTrue(Long id);
}
