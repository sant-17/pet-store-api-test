package tasks;

import interactions.GetRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.steps.ScenarioSteps;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeGetService extends ScenarioSteps implements Task  {

    private Integer petId;

    public ConsumeGetService withId(Integer petId) {
        this.petId = petId;
        return this;
    }

    @Step("Hacer método GET por ID")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetRequest.resource("/{id}")
                        .with(request -> request.pathParam("id", petId))
        );
    }

    public static ConsumeGetService makeGetRequest() {
        return instrumented(ConsumeGetService.class);
    }
}
