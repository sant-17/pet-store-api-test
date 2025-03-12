package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ResponseCode;
import questions.ValidateDeleteBodyData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static tasks.ConsumeDeleteService.makeDeleteRequest;

public class DeleteStepDefinition extends SetService{

    @When("envía una solicitud DELETE con el id {string}")
    public void enviaUnaSolicitudDELETEConElId(String id) {
        actor.attemptsTo(
                makeDeleteRequest().withEndpointAndId(id)
        );
    }

    @Then("valida el estado de dicha petición como eliminado con el id {string}")
    public void validaElEstadoDeDichaPeticionComoEliminadoConElId(String id) {
        actor.should(
                seeThat(
                        "El código respuesta es válido",
                        ResponseCode.getRespondeCode(), equalTo(SC_OK)
                ),
                seeThat("El cuerpo de la respuesta es válido",
                        ValidateDeleteBodyData.match(id))
        );
    }
}
