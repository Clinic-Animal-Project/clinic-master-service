package com.clinicanimal.master.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicios extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicios")
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer duracion;
    private double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codigo_area")
    private Areas area;
}
