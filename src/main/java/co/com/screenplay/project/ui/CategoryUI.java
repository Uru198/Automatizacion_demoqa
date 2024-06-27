package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class CategoryUI {

    public static final Target BTN_CLOSE = Target.the("pulsa el boton cerrar del modal del login")
            .located(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-secondary"));

    //Localizador dinamico - items categoria para trabajar de forma dinamica
    public static final Target ITEM_CATEGORY = Target.the("Selecciona cualquiera de las tres categoria")
            .locatedBy("//div[@class='list-group']/a[{0}]");

    //Localizador lista - Icard productos para trabajar en formato de lista

    /*
    El método locatorListProducts es un método estático que devuelve una lista
    de elementos web (WebElement). Estos elementos son seleccionados usando una expresión
    XPath específica. El XPath selecciona todos los enlaces (<a>) con la clase hrefch que están
    dentro de un div con id='tbodyid'. Utiliza un actor del framework Serenity BDD para obtener el
    controlador del navegador y buscar los elementos en la página web actual.
    * */

    private static List<WebElement> locatorListProducts() {
        String xpath = "//div[@id='tbodyid']//h4/a[@class='hrefch']";
        //BrowseTheWeb se trabaja para este tipo de elementos
        return BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().findElements(By.xpath(xpath));
    }

    public static List<WebElement> getLocatorListProducts() {
        return locatorListProducts();
    }
}
