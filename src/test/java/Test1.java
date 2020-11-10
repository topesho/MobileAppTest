import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {
    public static String userName = "tshodein1";
    public static String accessKey = "zuJHsyNbx6czWmdqayFn";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability("app", "bs://7f86e0811f04e7f0d6e3a5a85bfd87d566c80317");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>
                (new URL("https://tshodein1:zuJHsyNbx6czWmdqayFn@hub-cloud.browserstack.com/wd/hub"), caps);

        driver.manage().timeouts().wait(60);

        driver.findElementById("txtnext").click();
        driver.findElementById("txtnext").click();
        driver.findElementById("txtnext").click();

        driver.findElementById("email").sendKeys("tester@temitopes.com");
        //driver.FindElementById("mobile").SendKeys("01234567891");
        driver.findElementById("password").sendKeys("password");
        //driver.FindElementById("repassword").SendKeys("password");
        driver.findElementById("button").click();

        String Error = driver.findElementsByXPath("hierarchy/android.widget.Toast").toString();

        Thread.sleep(3000);

        //Assert.That(Error.Contains("Unsuccessful Login! Please try again"), Is.False);

        WebElement Content = driver.findElementById("titletxt");
        WebElement Register = driver.findElementById("signup");

        if (Content.isDisplayed())
        {
           assertThat(Register.isDisplayed()).isTrue();
        }

        else if (!Content.isDisplayed())
        {
          assertThat(Register.isDisplayed()).isFalse();
        }

        driver.quit();
    }
}
