package org.acme.quarkus.sample;



import javax.validation.constraints.NotNull;

import org.acme.quarkus.sample.client.Hero;
import org.acme.quarkus.sample.client.Villain;

public class Fighters {

    @NotNull
    public Hero hero;
    @NotNull
    public Villain villain;

    @Override
    public String toString() {
        return "Fighters{" +
            "hero=" + hero +
            ", villain=" + villain +
            '}';
    }
}