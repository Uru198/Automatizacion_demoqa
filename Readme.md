##Ejecuciones a nivel de consola

Con el siguiente comando limpiara el proyecto y luego ejecuta todo los escenarios
y nos dara un reporte:

./gradlew clean test

Este comando sirve para ejecutar test por un feature en especifico:

./gradlew test --tests "co.com.screenplay.project.runners.RunnerOpenWeb"

Este comando sirven para generar un reporte y extraerlo del "single-page-html" ubicado
en el build.gradle para eso se configuro el logback-test.xml para que nos diera una fecha en
especifico:

./gradlew reports

Este comando nos limpia los reportes: 

./gradlew clearReports




