package com.clinicanimal.master.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roles extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_roles")
    private Long id;
    @Column(name = "nombre_rol")
    private String rolNombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name="acceso_Web")
    private boolean accesoWeb;
    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Personal> personalList;
}
