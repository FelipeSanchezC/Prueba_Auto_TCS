package com.prueba.automatizacion.tcs.Interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.logging.Level;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitFor implements Interaction {

    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static final int SECONDS_TO_MILLISECONDS = 1000;
    private final int milliseconds;

    public WaitFor(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(this.milliseconds);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "an error ocurred while attempting to wait for statement", e);
            Thread.currentThread().interrupt();
        }
    }

    public static WaitFor seconds(int seconds) {
        return instrumented(WaitFor.class, seconds * SECONDS_TO_MILLISECONDS);
    }

}
