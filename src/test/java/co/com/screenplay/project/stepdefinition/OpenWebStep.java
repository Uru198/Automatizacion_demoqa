package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.questions.ValidateElementsTextBtn;
import co.com.screenplay.project.tasks.*;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.screenplay.project.utils.Constants.ACTOR;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;
import static co.com.screenplay.project.utils.DataFaker.fakerNumberOneAndNine;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class OpenWebStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    /* quitamos este given y lo colocamos en el hook del stepdefinition
    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestwebSite(String actor) {
    }*/

    @And("desea validar la funcion de la carta de elementos")
    public void wantValidateTheFunctionOfTheElementChart() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                //Andres intenta attemptsTo hacer un click a un elemento
                FuntionsElementsTask.chchoose()
        );
    }

    @When("selecciona aleatoriamente alguna de las subfunciones")
    public void randomlySelectsSomeOfTheSubfunctions() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                ChooseSubElementsRandomTask.witchParams(fakerNumberOneAndNine())
        );
    }

    // gracias al Slf4j nos ahorramos el codigo del else {}
    @Then("visualizara en la cabecera el nombre de la opción elegida")
    public void willDisplayInTheHeaderTheNameOfTheChosenOption() {
        String validateText = OnStage.theActor(ACTOR).recall(REMEMBER_TEXT_BTN_SUB_ELEMENTS);
        if (validateText != null) {
            log.info(validateText);
        }
        //El actor es el centeo de atencion donde debe validar el validateText (REMEMBER_TEXT_BTN_SUB_ELEMENTS)
        theActorInTheSpotlight().should(seeThat(
                ValidateElementsTextBtn.witchParams(validateText))
        );
    }

}
