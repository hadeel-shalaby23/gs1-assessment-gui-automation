package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload extends BaseTest {

    @Test
    public void uploadImage() {

        // Click "File Upload"
        WebElement fileUploadLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("File Upload")));
        fileUploadLink.click();

        // Get image path
        Path imagePath = Paths.get(System.getProperty("user.dir"), "cat-image.jpg").toAbsolutePath();
        Assert.assertTrue(Files.exists(imagePath), "Image file does not exist: " + imagePath);

        // Choose image file
        WebElement chooseFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")));
        chooseFile.sendKeys(imagePath.toString());

        // Upload file
        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("file-submit")));
        uploadButton.click();

        // Assert on success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        Assert.assertEquals(successMessage.getText(), "File Uploaded!", "No Success Message");

        // Assert on image file name
        WebElement uploadedFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        Assert.assertEquals(uploadedFile.getText(), "cat-image.jpg", "Incorrect File name");

    }



}
