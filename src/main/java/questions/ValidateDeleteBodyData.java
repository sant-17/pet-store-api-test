package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ValidateDeleteBodyData implements Question<Boolean> {

    protected String id;

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateDeleteBodyData.class);

    public ValidateDeleteBodyData(String id) {
        this.id = id;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();
        String responseMessage = responseBody.getString("message");

        boolean isMatch = Objects.equals(responseMessage, id);

        LOGGER.info("{} está validando el cuerpo de la respuesta. ID esperado: {}, Mensaje recibido: {}, Resultado: {}",
                actor.getName(), id, responseMessage, isMatch);

        return isMatch;
    }

    public static ValidateDeleteBodyData match(String id) {
        return new ValidateDeleteBodyData(id);
    }
}
