package cucumberframework;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tool.TestBase;

public class Hook extends TestBase {

    @Before
    public void setUp(){
        initialization("url");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
