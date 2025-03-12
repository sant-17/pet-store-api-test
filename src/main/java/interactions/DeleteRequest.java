package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class DeleteRequest extends RestInteraction {
    private final String id;

    public DeleteRequest(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log()
                .all()
                .delete(
                        as(actor)
                                .resolve(id)
                )
                .then()
                .log()
                .all();
    }

    public static DeleteRequest withEndpointAndId(String id) {
        return instrumented(DeleteRequest.class, id);
    }
}
