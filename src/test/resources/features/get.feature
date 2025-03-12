Feature:  Consumo de la PetStoreApi con el método GET

  Scenario Outline: Crear y luego buscar una mascota por su ID
    Given que un usuario obtiene la url base de la api
    And agregó una mascota con los datos: id "<id>", nombre "<name>" y estado "<status>"
    When envío una solicitud GET para obtener la información de la mascota con <id>
    Then valida el estado de dicha petición
    And la mascota debe tener el id "<id>", nombre "<name>" y estado "<status>"

    Examples:
      | id  | name     | status    |
      | 268 | Max      | available |
      | 300 | Maxus    | available |