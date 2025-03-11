Feature: Consumo de la PetStoreApi con el método POST

  Scenario Outline: Agregar una nueva mascota
    Given que un usuario obtiene la url base de la api
    When envío una solicitud POST para agregar la mascota con los datos: id <id>, nombre "<name>" y estado "<status>"
    Then valida el estado de dicha petición
    And la mascota debe tener el id "<id>", nombre "<name>" y estado "<status>"
    Examples:
      | id  | name     | status    |
      | 101 | Firulais | available |
      | 102 | Michi    | pending   |