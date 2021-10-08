import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void testDoubleClick(){
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.id("doubleClickBtn"))).doubleClick().perform();
        WebElement lblFinalMessage = driver.findElement(By.id("doubleClickMessage"));
        WebDriverWait wait = new WebDriverWait(driver,1); //tiempo a esperar
        wait.until(ExpectedConditions.textToBePresentInElement(lblFinalMessage,"You have done a double click"));

    }

    @Test(dependsOnMethods = {"testDoubleClick"})
    public void testRightClick(){
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.id("rightClickBtn"))).contextClick().perform();
        WebElement lblFinalMessage = driver.findElement(By.id("rightClickMessage"));
        WebDriverWait wait = new WebDriverWait(driver,1); //tiempo a esperar
        wait.until(ExpectedConditions.textToBePresentInElement(lblFinalMessage,"You have done a right click"));

    }

    @Test(dependsOnMethods = {"testRightClick"})
    public void testClick(){
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button"))).click().perform();
        WebElement lblFinalMessage = driver.findElement(By.id("dynamicClickMessage"));
        WebDriverWait wait = new WebDriverWait(driver,1); //tiempo a esperar
        wait.until(ExpectedConditions.textToBePresentInElement(lblFinalMessage,"You have done a dynamic click"));
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
