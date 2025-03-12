package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class ValidatePutBodyData implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatePutBodyData.class);

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

        boolean isMatch = Objects.equals(responseId, id) && Objects.equals(responseName, name) && Objects.equals(responseStatus, status);

        LOGGER.info("{} está validando el cuerpo de la respuesta PUT. \nID esperado: {}, ID recibido: {} \nNombre esperado: {}, Nombre recibido: {} \nEstado esperado: {}, Estado recibido: {} \nResultado: {}",
                actor.getName(), id, responseId, name, responseName, status, responseStatus, isMatch);

        return isMatch;
    }

    public static ValidatePutBodyData matches(String id, String name, String status) {
        return new ValidatePutBodyData(id, name, status);
    }

}
