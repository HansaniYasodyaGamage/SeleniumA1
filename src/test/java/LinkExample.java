import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;
    @BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }



    @Test
    public void linkTest(){

        //take me to dashboard
        WebElement homeLink=driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();


        //find my destination

        WebElement whereToGo=driver.findElement(By.partialLinkText("Find the URL"));
        String path=whereToGo.getAttribute("href");
        System.out.println("this link is going to"+ path);

        //am I broken link
        WebElement brokenLink=driver.findElement(By.linkText("Broken?") );
        brokenLink.click();
        String title=driver.getTitle();

        if (title.contains("404")){
            System.out.println("link is broken");
        }
        else{
            System.out.println("link is not broken");
        }
        driver.navigate().back();

        //duplicate link
        WebElement homeLink1=driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //no of link in the full page
        List<WebElement> countfullpagelinks= driver.findElements(By.tagName("a"));
        int pagelinkcout =countfullpagelinks.size();
        System.out.println("no of page links:"+ pagelinkcout);

        //no of links in a speecific section

        WebElement layoutElement=driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayoutWebElements=layoutElement.findElements(By.tagName("a"));
        System.out.println("count of layout web element"+ countLayoutWebElements.size());



    }
}
