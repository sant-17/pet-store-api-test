package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ValidatePostBodyData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static tasks.ConsumePostService.makePostRequest;

public class PostStepDefinition extends SetService{

    @When("envío una solicitud POST para agregar la mascota con los datos: id {int}, nombre {string} y estado {string}")
    public void envioUnaSolicitudPOSTParaAgregarLaMascotaConLosDatosIdNombreYEstado(Integer id, String name, String status) {
        actor.attemptsTo(
                makePostRequest().withData(id, name, status)
        );
    }

}
