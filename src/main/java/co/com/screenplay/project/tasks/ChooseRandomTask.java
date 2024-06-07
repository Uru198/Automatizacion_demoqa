package co.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.screenplay.project.ui.HomeUI.BTN_ELEMENTS;
import static co.com.screenplay.project.ui.HomeUI.BTN_LIST_ELEMENTS;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;


//Con esto nos evitamos crear un constructor
@AllArgsConstructor
public class ChooseRandomTask implements Task {

    //Este metodo genera un numero random del 1 al 9 y se hace con
    private String numberRandomBtn;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String number = numberRandomBtn;
        actor.attemptsTo(Scroll.to(BTN_ELEMENTS),
                Click.on(BTN_LIST_ELEMENTS.of(
                        number))
        );

        String textBtn = BTN_LIST_ELEMENTS.of(
                number).resolveFor(actor).getText();
        //Lo que estamos diciendo aqui es que me recuerden el valor que se esta capturando textBtn = BTN_LIST_ELEMENTS
        //Y ese nuevo valor sera ahora el de REMEMBER_TEXT_BTN_SUB_ELEMENTS
        actor.remember(REMEMBER_TEXT_BTN_SUB_ELEMENTS, textBtn);
    }

    public static ChooseRandomTask witchParams(String numberRandomBtn) {
        return Tasks.instrumented(ChooseRandomTask.class,numberRandomBtn);
    }
}
