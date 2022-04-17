package GoogleSearch;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/GoogleSearch/features"},
        glue = {"GoogleSearch/stepDef"}
)


public class googleRunner extends AbstractTestNGCucumberTests {

}
