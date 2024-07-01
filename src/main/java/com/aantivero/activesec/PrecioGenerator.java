package com.aantivero.activesec;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class PrecioGenerator {

    private Random random = new Random();

    /**
     * A bean producing random prices every 5 seconds.
     * @return
     */
    @Outgoing("generador-precio")
    public Multi<Integer> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(tick -> random.nextInt(100));
    }
}
