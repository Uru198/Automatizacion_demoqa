package co.com.screenplay.project.stepdefinition.hook;

import co.com.screenplay.project.hook.OpenWeb;
import co.com.screenplay.project.utils.Time;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Constants.TITLE;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestwebSite(String actor) {
        //aqui le pasamos al actor por parametro el cual esta en el feature en dado "Andres"
        //Luego que intente attemptsTo() llamar una clase
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.broserURL()
        );
        //despues de que se habra la pagina web espere un tiempo corto TIME_SHORT siendo una costante
        waiting(TIME_SHORT);
        //Aqui le desimos al robor que busque ese algo en la pagina web
        //El actor es el centro de atencion le indica que deberia GivenThenThen
        //se va a recibir una captura que el genera y que obtenga de la pagina
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        //Aqui se aplica la sobrecarga tiene varias formas de implementar este metodo
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)
                )
        );

    }
}
