package tasks;

import dto.PetDto;
import interactions.PostRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.steps.ScenarioSteps;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumePostService extends ScenarioSteps implements Task {

    private Integer id;
    private String name;
    private String status;

    public ConsumePostService withData(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
        return this;
    }

    @Step("Hacer método POST")
    @Override
    public <T extends Actor> void performAs(T actor) {
        PetDto pet = new PetDto(id, name, status);

        actor.attemptsTo(
                PostRequest.withoutResource()
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(pet)
                        )
        );
    }

    public static ConsumePostService makePostRequest() {
        return instrumented(ConsumePostService.class);
    }
}
