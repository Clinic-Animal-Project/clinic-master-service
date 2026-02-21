package com.clinicanimal.master.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(name = "mascota")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mascota extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;
    @Column(name = "nom_mascota")
    private String nombre;
    @Column(name = "especie")
    private String especie;
    @Column(name = "raza")
    private String raza;
    @Column(name = "edad")
    private int edad;
    @Column(name = "sexo")
    private String sexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


}
