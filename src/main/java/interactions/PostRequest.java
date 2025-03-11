package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostRequest extends RestInteraction {

    public PostRequest() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().post(as(actor).resolve("")).then().log().all();
    }

    public static PostRequest withoutResource() {
        return instrumented(PostRequest.class);
    }
}
