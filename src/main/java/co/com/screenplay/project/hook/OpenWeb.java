package co.com.screenplay.project.hook;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class OpenWeb implements Task {

    //Es una utilidad que nos facilita a encontrar  las variables en demoqa
    private EnvironmentVariables environmentVariables;

    public OpenWeb(String webUrl) {
        this.webUrl = webUrl;
    }

    private String webUrl;

    //la anotacion step nos permitira en los reportes mostrar una
    // pequeña descripcion de los que se hace ahi "{0} abre el navegador web"
    @Override
    @Step("{0} abre el navegador web")
    public <T extends Actor> void performAs(T actor) {
        //Le estamos diciendo que busque una variable en especifico (serenity.conf)
        String pathWebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(webUrl);
        //Indicarle al actor que abra la pagina web
        actor.attemptsTo(Open.url(pathWebUrl));
    }

    //El nombramiento del metodo inicia por minuscula y despues mayuscula
    public static Performable browserURL(String webUrl) {
        return instrumented(OpenWeb.class, webUrl);
    }
}
