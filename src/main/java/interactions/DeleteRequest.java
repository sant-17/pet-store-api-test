package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class DeleteRequest extends RestInteraction {
    private final String endpoint;
    private final String id;

    public DeleteRequest(String endpoint, String id) {
        this.endpoint = endpoint;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String resource = endpoint + id;
        rest()
                .log()
                .all()
                .delete(
                        as(actor)
                                .resolve(resource)
                )
                .then()
                .log()
                .all();
    }

    public static DeleteRequest withEndpointAndId(String endpoint, String id) {
        return instrumented(DeleteRequest.class, endpoint, id);
    }
}
