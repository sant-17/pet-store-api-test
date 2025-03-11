Feature: Consumo de la PetStore API con el método PUT

  Scenario Outline: Actualizar información de una mascota existente
    Given que un usuario obtiene la url base de la api
    And agregó una mascota con los datos: id "<id>", nombre "<name>" y estado "<status>"
    When el usuario actualiza el campo "<updated_field>" de la mascota <id> al valor "<new_value>"
    Then valida el estado de dicha petición
    And la mascota debe reflejar los datos actualizados correctamente

    Examples:
      | id  | name   | status     | updated_field | new_value     |
      | 301 | Lupe   | available  | nombre        | Lupi          |
