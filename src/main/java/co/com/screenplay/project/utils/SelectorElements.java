package co.com.screenplay.project.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static co.com.screenplay.project.ui.CategoryUI.getLocatorListProducts;
import static co.com.screenplay.project.utils.Constants.ONE;
import static co.com.screenplay.project.utils.WebActions.click;
public class SelectorElements {

    private SelectorElements(){}

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    private static int getProductsRandom() {
        //Aqui se esta diciendo que escoja entre uno y la cantidad de elemetos que exista en los productos(6)
        return faker.number().numberBetween(ONE, getLocatorListProducts().size());
    }

    public static void selectRandomProducts() {
        //Este click es creado en la clase WebActions
        click(getLocatorListProducts().get(getProductsRandom()));
    }
}
