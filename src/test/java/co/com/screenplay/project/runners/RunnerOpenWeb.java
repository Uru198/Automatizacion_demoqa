package co.com.screenplay.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//Aqui se debe especificar
@CucumberOptions(
        features = "src/test/resources/features/openweb.feature",
        //es la ruta de los pasos a definir
        glue = "co.com.screenplay.project.stepdefinition",
        //al momento de generar los metodos (los features) se transforman en codigo
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //nos permite ejecutar o un scenario completo o muchos scenarios
        tags = "@successful"
)
public class RunnerOpenWeb {

}
