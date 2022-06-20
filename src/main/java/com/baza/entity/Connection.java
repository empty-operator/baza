package com.baza.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn
    private Tariff tariff;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

}
