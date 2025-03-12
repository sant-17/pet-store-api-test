package stepDefinitions;

import io.cucumber.java.en.When;
import static tasks.ConsumeGetService.makeGetRequest;

public class GetStepDefinition extends SetService{
    @When("envío una solicitud GET para obtener la información de la mascota con {int}")
    public void envioUnaSolicitudGETParaObtenerLaInformacionDeLaMascotaCon(Integer id) {
        actor.attemptsTo(
                makeGetRequest().withId(id)
        );
    }
}
