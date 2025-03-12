package tasks;

import interactions.GetRequest;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeGetService extends ScenarioSteps implements Task  {

    private Integer id;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeGetService.class);

    public ConsumeGetService withId(Integer petId) {
        this.id = petId;
        return this;
    }

    @Step("Hacer método GET por ID")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} está enviando la petición GET con el ID {}",
                actor.getName(),
                id
        );
        
        actor.attemptsTo(
                GetRequest.resource("/{id}")
                        .with(request -> request.pathParam("id", id))
        );
    }

    public static ConsumeGetService makeGetRequest() {
        return instrumented(ConsumeGetService.class);
    }
}
