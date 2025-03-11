package stepDefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constants.ACTOR;

public class SetService {
    protected static final Actor actor = new Actor(ACTOR);

    protected void setup(String baseUrl) {
        actor.can(CallAnApi.at(baseUrl));
    }
}
