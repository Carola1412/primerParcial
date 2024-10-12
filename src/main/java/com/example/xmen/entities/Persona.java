package com.example.xmen.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Persona extends Base {

    private String nombre;
    private String apellido;
    private int dni;

    private boolean esMutante;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_adn")
    private Adn adn;

}

