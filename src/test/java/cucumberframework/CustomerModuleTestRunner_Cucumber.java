package cucumberframework;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/CubeCart-cucumber"}
,features = {"src/test/resources"}
,tags = "@ViewListOfCustomer",
monochrome = true)
public class CustomerModuleTestRunner_Cucumber {
}
