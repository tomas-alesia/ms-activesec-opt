package com.aantivero.activesec;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PrecioStorage {

    @Incoming("precios")
    @ActivateRequestContext
    public Uni<Void> store(int precioEnUsd) {
        Precio precio = new Precio();
        precio.valor = precioEnUsd;
        return Panache.withTransaction(precio::persist)
                .replaceWithVoid();
    }
}
