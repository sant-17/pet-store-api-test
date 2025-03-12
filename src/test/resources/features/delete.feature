Feature: Consumo de la PetStoreApi con el método DELETE

  Scenario Outline: Eliminar una mascota
    Given que un usuario obtiene la url base de la api
    And agregó una mascota con los datos: id "<id>", nombre "<name>" y estado "<status>"
    When envía una solicitud DELETE con el id "<id>"
    Then valida el estado de dicha petición como eliminado con el id "<id>"

    Examples:
      | id  | name      | status    |
      | 101 | Firulais  | available |
      | 102 | Michi     | pending   |