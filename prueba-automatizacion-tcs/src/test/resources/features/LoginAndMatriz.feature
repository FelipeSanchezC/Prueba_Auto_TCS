#language: en

@UserLogin
Feature: El usuario realiza el proceso para hacer el Login y el flujo asociado a la matriz


  Scenario Outline: Login de usuario con resultado exitoso
    Given el usuario ingresa con los datos "<username>" "<password>"
    When el realiza el proceso matricial para terminar los ciclos
    Then el valida el hash de exito despues de todos los ciclos

    Examples:
      | username | password                                         |
      | 679068   | 10df2f32286b7120My0zLTg2MDk3Ng==30e0c83e6c29f1c3 |