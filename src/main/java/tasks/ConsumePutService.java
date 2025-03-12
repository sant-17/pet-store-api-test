package tasks;

import dto.PetPutDto;
import interactions.PutRequest;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ConsumePutService implements Task {

    private final PetPutDto petPutDto;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumePutService.class);

    public ConsumePutService(PetPutDto petPutDto) {
        this.petPutDto = petPutDto;
    }

    @Step("Actualizar mascota con PUT")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} está enviando la petición PUT para actualizar la mascota con el id {}",
                actor.getName(),
                petPutDto.getId()
        );

        actor.attemptsTo(
                PutRequest.withBody(petPutDto)
        );
    }

    public static ConsumePutService withPet(PetPutDto petPutDto) {
        return instrumented(ConsumePutService.class, petPutDto);
    }
}
