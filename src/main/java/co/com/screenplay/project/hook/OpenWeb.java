package co.com.screenplay.project.hook;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.screenplay.project.utils.Constants.WEB_URL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWeb implements Task {

    //Es una utilidad que nos facilita a encontrar  las variables en demoqa
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        //Le estamos diciendo que busque una variable en especifico (serenity.conf)
        String pathWebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEB_URL);
        //Indicarle al actor que abra la pagina web
        actor.attemptsTo(Open.url(pathWebUrl));
    }

    //El nombramiento del metodo inicia por minuscula y despues mayuscula
    public static Performable broserURL() {
        return instrumented(OpenWeb.class);
    }
}
