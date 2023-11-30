package stepdefinitions;

import com.prueba.automatizacion.tcs.utilities.Url;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.aNewActor;

public class ComunStepDefinitions {
    private final Url page = new Url();

    @Before
    public void SetUp(){

        OnStage.setTheStage(new OnlineCast());
        aNewActor().attemptsTo(
                Open.browserOn(page)
        );

    }
}
