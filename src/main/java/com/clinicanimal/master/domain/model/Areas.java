package com.clinicanimal.master.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "areas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Areas extends Auditable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_areas")
    private Long id;
    @Column(name="nombre_area")
    private String nomArea;
    @Column(name="descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "areas",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Personal> personalList;
}
