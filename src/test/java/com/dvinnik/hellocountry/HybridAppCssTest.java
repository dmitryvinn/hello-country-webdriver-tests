package com.dvinnik.hellocountry;

import com.dvinnik.hellocountry.utils.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.dvinnik.hellocountry.utils.Constants.WEBSITE_URL;
import static org.junit.Assert.assertEquals;


public class HybridAppCssTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.opera.driver", Constants.DRIVER_PATH);
        driver = new OperaDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Use 927 x 518
     */
    @Test
    public void testDesktopFlagState() {
        driver.manage().window().setSize(new Dimension(927, 518));
        driver.get(WEBSITE_URL);

        WebElement flag = getFlag();

        assertEquals(flag.getCssValue("visibility"), "visible");
    }

    /**
     * Use 374 x 667
     */
    @Test
    public void testMobileFlagState() {
    }

    /**
     * Use 443 x 667
     */
    @Test
    public void testPlatformTransitionFlagState() {
    }

    private WebElement getFlag() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("countryFlag")));
    }
}
