package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void sleep(Long milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void click(WebElement element){
        waitForElementClickability(element);
        moveIntoView(element);
        highlightElement(element);
        element.click();
    }

    public void sendKeys(WebElement element, String inputText){
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        element.sendKeys(inputText);
    }

    public String getText(WebElement element){
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        return element.getText();
    }

    public void waitForElementClickability(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void moveIntoView(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }
    public void moveToElement(WebElement element) {
        waitForElementVisibility(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(int i = 0; i < 4; i++){
            try{
                if(i % 2 == 0){
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                }else {
                    sleep(250L);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


}
