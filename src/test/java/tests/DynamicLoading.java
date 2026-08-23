package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoading extends BaseTest {

    @Test
    public void dynamicLoading() {

        // Click "Dynamic Loading"
        WebElement dynamicLoadingLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dynamic Loading")));
        dynamicLoadingLink.click();

        // Click "Example 2"
        WebElement example2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Example 2: Element rendered after the fact")));
        example2.click();

        // Click "Start"
        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start button")));
        startButton.click();

        // Wait until loading finishes
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        // Assert on message
        Assert.assertEquals(helloWorldText.getText(), "Hello World!", "Incorrect Message"
        );

    }


}
