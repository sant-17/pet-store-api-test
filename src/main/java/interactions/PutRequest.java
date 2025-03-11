package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PutRequest extends RestInteraction {

    private final Object body;

    public PutRequest(Object body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .put(as(actor).resolve(""))
                .then()
                .log().all();
    }

    public static PutRequest withBody(Object body) {
        return instrumented(PutRequest.class, body);
    }
}
