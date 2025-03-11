package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ResponseCode;
import questions.ValidatePostBodyData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static tasks.ConsumePostService.makePostRequest;
import static utils.Constants.BASE_URL;

public class SharedStepDefinitions extends SetService {

    @Given("que un usuario obtiene la url base de la api")
    public void queUnUsuarioObtieneLaUrlBaseDeLaApi() {
        OnStage.setTheStage(new OnlineCast());
        setup(BASE_URL);
    }

    @And("agregó una mascota con los datos: id {string}, nombre {string} y estado {string}")
    public void agregoUnaMascotaConLosDatosIdNombreYEstado(String id, String name, String status) {
        actor.attemptsTo(
                makePostRequest().withData(Integer.parseInt(id), name, status)
        );
    }


    @Then("valida el estado de dicha petición")
    public void validaElEstadoDeDichaPeticionOK() {
        actor.should(
                seeThat(
                        "El código respuesta es válido",
                        ResponseCode.getRespondeCode(), equalTo(SC_OK)
                )
        );
    }

    @Then("la mascota debe tener el id {string}, nombre {string} y estado {string}")
    public void laMascotabaDebeTenerElIdNombreYEstado(String id, String name, String status) {
        actor.should(
                seeThat(
                        "Se creó correctamente",
                        ValidatePostBodyData.matches(id, name, status)
                )
        );
    }
}
