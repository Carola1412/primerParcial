package com.example.xmen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Adn extends Base{
    @Column(unique = true)
    private String [] adn;

    private boolean mutante;

    @OneToOne(mappedBy = "adn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Persona persona;
}

