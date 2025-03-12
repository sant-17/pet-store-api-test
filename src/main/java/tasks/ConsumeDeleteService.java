package tasks;

import interactions.DeleteRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeDeleteService extends ScenarioSteps implements Task {

    private String id;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeDeleteService.class);

    public ConsumeDeleteService withEndpointAndId(String id) {
        this.id = id;
        return this;
    }

    @Step("Hacer método DELETE")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} está enviando la petición DELETE con el ID {}",
                actor.getName(),
                id
        );

        actor.attemptsTo(
                DeleteRequest.withEndpointAndId("/" + id)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeDeleteService makeDeleteRequest() {
        return instrumented(ConsumeDeleteService.class);
    }
}
