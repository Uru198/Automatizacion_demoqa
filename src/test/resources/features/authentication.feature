#author: Andres Felipe Uruburu Berrio
#language: es

#Tener encuenta que esto lo va leer los clientes
#Siempre en cada scenario se va a mensionar al usuario solo una vez
@authenticationLogin
Característica: Autenticacion Exitosa

  Yo como TAE(test automation engineer)
  Quiero realizar una prueba de automatizacion al sitio web
  Para comprobar la robuste y control de errores del app, funciones correctas

  Antecedentes:
    Dado "Andres" abre el sitio web de pruebas

  @authenticationSuccess
  Escenario: Autenticacion de usuario exitosa
    Cuando ingresa las credenciales
    Entonces visualizara el home y espera una validacion