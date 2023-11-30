package stepdefinitions;

import com.prueba.automatizacion.tcs.Interactions.WaitFor;
import com.prueba.automatizacion.tcs.tasks.BonusQuestion;
import com.prueba.automatizacion.tcs.tasks.SelectCorrectButtonAndSum;
import com.prueba.automatizacion.tcs.tasks.UserLogin;
import com.prueba.automatizacion.tcs.utilities.GetCycles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.prueba.automatizacion.tcs.userinterfaces.LoginAndMatrizUserInterfaces.EXTRACT_CYCLES_TOTAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginAndMatrizStepDefinitions {


    String cicloactual="";
    String cantidadciclos="";

    @Given("el {word} ingresa con los datos {string} {string}")
    public void elUsuarioIngresaConLosDatos(String name, String username, String password){
        theActorCalled(name).wasAbleTo(UserLogin.userLogin(username,password));
    }

    @When("el realiza el proceso matricial para terminar los ciclos")
    public void elRealizaElProcesoMatricialParaTerminarLosCiclos() {
        cicloactual = GetCycles.CicloActual(EXTRACT_CYCLES_TOTAL.getCssOrXPathSelector());
        cantidadciclos = GetCycles.CantidadCiclos(EXTRACT_CYCLES_TOTAL.getCssOrXPathSelector());

        int cicloactuali = Integer.parseInt(cicloactual);
        int cantidadciclosi = Integer.parseInt(cantidadciclos);

        while (cicloactuali<cantidadciclosi){
            theActorInTheSpotlight().wasAbleTo(
                    SelectCorrectButtonAndSum.selectCorrectButton(),
                    BonusQuestion.bonusQuestion()
            );
        }
        WaitFor.seconds(10000);
    }

    @Then("el valida el hash de exito despues de todos los ciclos")
    public void elValidaElHashDeExitoDespuesDeTodosLosCiclos() {
    }
}
