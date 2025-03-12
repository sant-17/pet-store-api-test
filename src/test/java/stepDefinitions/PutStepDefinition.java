package stepDefinitions;

import dto.PetDtoPut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import questions.ValidatePutBodyData;
import tasks.ConsumePutService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class PutStepDefinition extends SetService{

    @When("el usuario actualiza el campo {string} de la mascota {int} al valor {string}")
    public void elUsuarioActualizaElCampoDeLaMascotaIdAlValor(String updated_field, Integer id, String new_value) {
        PetDtoPut pet = new PetDtoPut();
        pet.setId(id);

        switch (updated_field.toLowerCase()) {
            case "name":
            case "nombre":
                pet.setName(new_value);
                pet.setStatus("available");
                break;
            case "status":
            case "estado":
                pet.setStatus(new_value);
                pet.setName("DefaultName");
                break;
            default:
                throw new IllegalArgumentException("Campo no válido: " + updated_field);
        }

        actor.remember("expectedPet", pet);

        actor.attemptsTo(ConsumePutService.withPet(pet));
    }

    @And("la mascota debe reflejar los datos actualizados correctamente")
    public void laMascotaDebeReflejarLosDatosActualizadosCorrectamente() {
        PetDtoPut expectedPet = actor.recall("expectedPet");

        actor.should(
                seeThat(
                        "Se actualizó correctamente",
                        ValidatePutBodyData.matches(
                                String.valueOf(expectedPet.getId()),
                                expectedPet.getName(),
                                expectedPet.getStatus()
                        )
                )
        );
    }
}
