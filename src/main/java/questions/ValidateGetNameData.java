package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Objects;

public class ValidateGetNameData implements Question<Boolean> {

    protected String name;

    public ValidateGetNameData(String name) {
        this.name = name;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();

        String responseName = responseBody.getString("name");

        return Objects.equals(responseName, name);
    }

    public static ValidateGetNameData match(String name) {
        return new ValidateGetNameData(name);
    }
}
