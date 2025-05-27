import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class buttonExample {

    WebDriver driver;
    @BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");


    }

    @Test
    public void buttonTest(){
        //Click and Confirm title.
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle= "Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("actual tile is equal to expected Title");
        }else{
            System.out.println("actual tile is not equal to expected Title");
        }

        //Find the position of the Submit button
        driver.navigate().back();
        WebElement getPostion =driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint = getPostion.getLocation();
        int x=xypoint.getX();
        int y=xypoint.getY();
        System.out.println("x axis is "+ x + "y axis is" + y);


        //Find the Save button color
        WebElement buttonColor=driver.findElement(By.id("j_idt88:j_idt96"));
        String color=buttonColor.getCssValue("background-color");
        System.out.println("button color is " + color);

        //Find the height and width of this button
        WebElement hwOfButton=driver.findElement(By.id("j_idt88:j_idt98"));
        int height=hwOfButton.getSize().getHeight();
        int width=hwOfButton.getSize().getWidth();
        System.out.println("height " + height + "width "  + width);
    }

}
