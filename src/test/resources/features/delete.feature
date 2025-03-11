Feature: Consumo de la PetStoreApi con el método DELETE

  Scenario Outline: Eliminar una mascota
    Given que un usuario obtiene la url base de la api
    And agregó una mascota con los datos: id "<id>", nombre "<name>" y estado "<status>"
    When envía una solicitud DELETE al recurso "<endpoint>" con el id "<id>"
    Then valida el estado de dicha petición como eliminado

    Examples:
      | id  | name      | status    | endpoint  |
      | 101 | Firulais  | available | /pet/     |
      | 102 | Michi     | pending   | /pet/     |