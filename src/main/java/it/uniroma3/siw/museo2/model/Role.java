package it.uniroma3.siw.museo2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "utente")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }
}
