import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class textBoxExample {

    WebDriver driver;
    @BeforeMethod

    public void openLinkPage(){

        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBrowserVersion("135");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxes(){

        //1.Type your name
        WebElement name=driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Hansani Yaz");
        //2.append country to the city
        WebElement appendName=driver.findElement(By.id("j_idt88:j_idt91"));
        appendName.sendKeys("India");

        //3.verify if textbox is disabled
        Boolean isDisabledTextBox=driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("is text box enabled :" + isDisabledTextBox);

        //4.clear the typed text
        WebElement cleartext=driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        cleartext.clear();

        //retrieve typed text
        WebElement retreiveText=driver.findElement(By.id("j_idt88:j_idt97"));
        String value=retreiveText.getAttribute("value");
        System.out.println("retreived value is :"+value);


        //Type email and Tab. Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("hansani@gmail.com"+ Keys.TAB + "Confirm control moved to next element.");

    }
}
