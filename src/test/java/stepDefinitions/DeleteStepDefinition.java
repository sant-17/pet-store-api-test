package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ResponseCode;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.hamcrest.Matchers.equalTo;
import static tasks.ConsumeDeleteService.makeDeleteRequest;
import static tasks.ConsumePostService.makePostRequest;

public class DeleteStepDefinition extends SetService{

    @When("envía una solicitud DELETE al recurso {string} con el id {string}")
    public void enviaUnaSolicitudDELETEAlRecursoConElId(String endpoint, String id) {
        actor.attemptsTo(
                makeDeleteRequest().withEndpointAndId(endpoint, id)
        );
    }

    @Then("valida el estado de dicha petición como eliminado")
    public void validaElEstadoDeDichaPeticionComoEliminado() {
        actor.should(
                seeThat(
                        "El código respuesta es válido",
                        ResponseCode.getRespondeCode(), equalTo(SC_NOT_FOUND)
                )
        );
    }
}
