package co.com.screenplay.project.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFaker {
    private DataFaker(){}

    //Aqui le decimos que dentro de su informacion que contiene por dentro vaya al repo y busque informacion
    //Relevante que sea del directorio de colombia
    private static Faker faker = Faker.instance(new Locale("es","CO"));

    //Genereme un numero del 1 al 9
    public static String fakerNumberOneAndNine(){
        return String.valueOf(faker.number().numberBetween(1,9));
    }
}
