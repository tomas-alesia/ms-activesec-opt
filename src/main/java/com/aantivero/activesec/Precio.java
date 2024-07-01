package com.aantivero.activesec;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Precio extends PanacheEntity {

    public int valor;
}
