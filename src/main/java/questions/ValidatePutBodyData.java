package questions;

import dto.PetDtoTest;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Objects;


public class ValidatePutBodyData implements Question<Boolean> {

    protected String id;
    protected String name;
    protected String status;

    public ValidatePutBodyData(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();

        String responseId = responseBody.getString("id");
        String responseName = responseBody.getString("name");
        String responseStatus = responseBody.getString("status");

        return Objects.equals(responseId, id) && Objects.equals(responseName, name) && Objects.equals(responseStatus, status);
    }

    public static ValidatePutBodyData matches(String id, String name, String status) {
        return new ValidatePutBodyData(id, name, status);
    }

}
