package tasks;

import interactions.DeleteRequest;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.steps.ScenarioSteps;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeDeleteService extends ScenarioSteps implements Task {

    private String endpoint;
    private String id;

    public ConsumeDeleteService withEndpointAndId(String endpoint, String id) {
        this.endpoint = endpoint;
        this.id = id;
        return this;
    }

    @Step("Hacer método DELETE")
    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.config = RestAssuredConfig.config()
                        .redirect(
                                RestAssured.config().getRedirectConfig().followRedirects(true)
                        );

        actor.attemptsTo(
                DeleteRequest.withEndpointAndId(endpoint, id)
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
