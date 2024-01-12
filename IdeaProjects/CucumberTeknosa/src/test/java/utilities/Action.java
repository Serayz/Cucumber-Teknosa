package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static utilities.Driver.getDriver;

public class Action {

    public static void clickElement(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.click();
    }


    public static void sendKeysElement(By xpath, String key){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.sendKeys(key);
    }

    public static String getTextElement(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        return element.getText();
    }

    public static void pressEnter(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        element.sendKeys(Keys.ENTER);

    }

    public static void  checkElementText(By xpath, String text){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getText(),text);
    }

    public static void elementPresent(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
    }
    public static void elementNotPresent(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
    }

    public static void  checkElementValue(By xpath, String text){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getAttribute("value"),text);
    }

    public static void clearText(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        element.clear();
    }

    public static void scrollUntilVisible(By xpath) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'})",element);

    }


    public static void focusElement(By xpath) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("arguments[0].focus();", element);
    }
    public static void writetxt(By xpath) throws IOException {
        //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        // WebElement element=Driver.getDriver().findElement(xpath);
        WebElement element = Driver.getDriver().findElement(xpath);
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-yyyy HH-mm") ;
        FileWriter fw=new FileWriter("testout_"+dateFormat.format(date)+".txt",true);
        fw.write("TeknosaOdev"+element.getText()+" ");
        fw.close();

    }
}
