package kolotyuk.tests.android;
// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:platformVersion", "13")
                .amend("platformName", "Android")
                .amend("appium:appPackage", "com.fuib.digital.corporate.stage")
                .amend("appium:appActivity", "com.pumb.pumb_business.MainActivity")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        URL remoteUrl =  new URL("http://0.0.0.0:4724/wd/hub");
        driver = new AndroidDriver(remoteUrl, options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void userCanLoginWithCorrectPasswordTest() {
        var el1 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Пропустити\"]"));
        el1.click();

        var ell = driver.findElement(AppiumBy.className("android.widget.Button"));
//         driver.executeScript("mobile: hideKeyboard");
        var el2 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Зрозуміло\"]"));
        el2.click();
        var el3 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Увійти\"]/android.view.View[2]/android.widget.EditText[1]"));
        el3.click();
        var el4 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Увійти\"]/android.view.View[2]/android.widget.EditText[1]"));
        el4.sendKeys("test_shashl");
        var el5 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Увійти\"]/android.view.View[2]/android.widget.EditText[2]"));
        el5.click();
        var el6 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Увійти\"]/android.view.View[2]/android.widget.EditText[2]"));
        el6.sendKeys("Ss1111111");
        var el7 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Увійти\"]"));
        el7.click();
        var el8 = driver.findElement(AppiumBy.accessibilityId("Увійти"));
        el8.click();
        var el9 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Активувати пізніше\"]"));
        el9.click();
        var el10 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Завершити\"]"));
        el10.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
