package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import questions.ValidateGetNameData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static tasks.ConsumeGetService.makeGetRequest;

public class GetStepDefinition extends SetService{
    @When("envío una solicitud GET para obtener la información de la mascota con {int}")
    public void envíoUnaSolicitudGETParaObtenerLaInformaciónDeLaMascotaCon(Integer id) {
        actor.attemptsTo(
                makeGetRequest().withId(id)
        );
    }
}
