#author: Andres Felipe Uruburu Berrio
#language: es

#Tener encuenta que esto lo va leer los clientes
#Siempre en cada scenario se va a mensionar al usuario solo una vez

Característica: Abrir una pagina web

  Yo como alejandro
  Quiero realizar una prueba a la carta de elementos y las subFunciones
  Para comprobar la robuste y control de errores de la aplicacion o pagina web

  Antecedentes:
    Dado "Andres" abre el sitio web de pruebas

  @successful
  Escenario: validacion en la funcion del ID Card Elements
    Y desea validar la funcion de la carta de elementos
    Cuando selecciona aleatoriamente alguna de las subfunciones
    Entonces visualizara en la cabecera el nombre de la opción elegida