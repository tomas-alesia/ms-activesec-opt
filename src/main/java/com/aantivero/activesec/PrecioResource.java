package com.aantivero.activesec;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/precios")
public class PrecioResource {

    @GET
    public Uni<List<Precio>> getAllPrecios() {
        return Precio.listAll();
    }
}
