package tasks;

import dto.PetDtoPut;
import interactions.PutRequest;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ConsumePutService implements Task {

    private final PetDtoPut petDtoTest;

    public ConsumePutService(PetDtoPut petDtoTest) {
        this.petDtoTest = petDtoTest;
    }

    @Step("Actualizar mascota con PUT")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutRequest.withBody(petDtoTest)
        );
    }

    public static ConsumePutService withPet(PetDtoPut petDtoTest) {
        return instrumented(ConsumePutService.class, petDtoTest);
    }
}
