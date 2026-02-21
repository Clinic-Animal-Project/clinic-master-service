package com.clinicanimal.master.domain.model;

import com.clinicanimal.master.domain.model.estado.EstadoPersonal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personal extends Auditable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_personal")
    private Long id;
    @Column(name = "nombre_personal")
    private String nombrePersonal;
    @Column(name = "apellido_personal")
    private String apellidoPersonal;
    @Column(name = "edad")
    private int edad;
    @Column(name = "dni")
    private String dni;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name="contraseña")
    private String contraseña;
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    @Column(name="estado")
    @Enumerated (EnumType.STRING)
    private EstadoPersonal estadoPersonal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_rol")
    private Roles roles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codigo_area")
    private Areas areas;
}
