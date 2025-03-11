package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ValidatePostBodyData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static tasks.ConsumePostService.makePostRequest;

public class PostStepDefinition extends SetService{

    @When("envío una solicitud POST para agregar la mascota con los datos: id {string}, nombre {string} y estado {string}")
    public void envioUnaSolicitudPOSTParaAgregarLaMascotaConLosDatosIdNombreYEstado(String id, String name, String status) {
        actor.attemptsTo(
                makePostRequest().withData(Integer.parseInt(id), name, status)
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
