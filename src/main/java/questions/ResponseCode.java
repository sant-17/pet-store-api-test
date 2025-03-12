package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseCode implements Question<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseCode.class);

    @Override
    public Integer answeredBy(Actor actor) {
        int statusCode = SerenityRest.lastResponse().statusCode();
        LOGGER.info("{} obtuvo el código de respuesta: {}", actor.getName(), statusCode);
        return statusCode;
    }

    public static ResponseCode getRespondeCode() {
        return new ResponseCode();
    }
}
