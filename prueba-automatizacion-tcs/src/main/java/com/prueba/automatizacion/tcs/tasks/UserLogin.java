package com.prueba.automatizacion.tcs.tasks;

import com.prueba.automatizacion.tcs.userinterfaces.LoginAndMatrizUserInterfaces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class UserLogin implements Task{

    private final String username;
    private final String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable userLogin(String username, String password) {
        return instrumented(UserLogin.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginAndMatrizUserInterfaces.INCOME_USERNAME, isEnabled()).forNoMoreThan(Duration.ofSeconds(4)),
                Enter.keyValues(username).into(LoginAndMatrizUserInterfaces.INCOME_USERNAME),
                Enter.keyValues(password).into(LoginAndMatrizUserInterfaces.INCOME_PASSWORD),
                Click.on(LoginAndMatrizUserInterfaces.SELECT_SEND)
        );
    }

}
