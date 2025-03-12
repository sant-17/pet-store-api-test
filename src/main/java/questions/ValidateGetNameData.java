package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ValidateGetNameData implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateGetNameData.class);

    protected String name;

    public ValidateGetNameData(String name) {
        this.name = name;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath responseBody = SerenityRest.lastResponse().jsonPath();
        String responseName = responseBody.getString("name");

        boolean isMatch = Objects.equals(responseName, name);

        LOGGER.info("{} está validando el nombre en la respuesta. Nombre esperado: {}, Nombre recibido: {}, Resultado: {}",
                actor.getName(), name, responseName, isMatch);

        return isMatch;
    }

    public static ValidateGetNameData match(String name) {
        return new ValidateGetNameData(name);
    }
}
