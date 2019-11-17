package ming.zhang.selenium_demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class SeleniumDemoApplicationTests {

    @Test
    public void addBookToEmptyList() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
        ChromeDriver browser = new ChromeDriver();
        Actions action=new Actions(browser);
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);

        String baseUrl = "https://www.xueersi.com/course-center/s-23/s6/s-836?switch_grade=6&switch_subject=2";
        browser.get(baseUrl);
        WebElement elementByXPath = browser.findElementByXPath("//div[@class='right-bar__text']/strong");
        System.out.println(elementByXPath.getText());
        // 控制滚动条
        browser.executeScript("window.scrollTo(0, 1000);");
        WebElement elementByXPath2 = browser.findElementByXPath("//p[@class='global-header__region__tip']");
        // 控制鼠标
        action.moveToElement(elementByXPath2).perform();
        WebElement elementByXPath1 = browser.findElementByXPath("//div[@class='global-header__region__list']//span[2]");
        System.out.println("城市：" + elementByXPath1.getText());
        // 点击事件
        elementByXPath1.click();
        System.out.println("当前页面URL：" + browser.getCurrentUrl());
        Thread.sleep(5000);
        browser.quit();
    }

}
