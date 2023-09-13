package com.testing.web;

import com.testing.DriverSelf.GoogleDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @program: WebAutoTest
 * @ClassName WebKeyWord
 * @description: 对于页面完成关键字封装
 * @author: Sun
 * @create: 2023-09-11 21:49
 * @Version 1.0
 **/
public class WebKeyWord {

    //属性
    //浏览器驱动对象
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //方法
    //浏览器启动的方法
    public void openBrowser(String browserType) {
        switch (browserType) {
            case "chrome": {
                GoogleDriver googleDriver = new GoogleDriver();
                driver = googleDriver.getdriver();
                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS)
                break;

            }
        }

    }


    //访问网页的方法
    public void visitWeb(String url) {
        driver.get(url);
    }

    //网页前进/后退/刷新的方法
    public void forwardOrBackOrRefresh(String operation) {
        try {
            switch (operation) {
                case "forward": {
                    driver.navigate().forward();
                }
                case "back": {
                    driver.navigate().back();
                }
                case "refresh": {
                    driver.navigate().refresh();
                }
            }
        } catch (Exception e) {
            System.out.println(operation+"操作失败");
            throw new RuntimeException(e);
        }
    }


    //进行输入的方法
    public void inputById(String id, String content) throws InterruptedException {
        try {
            WebElement element = driver.findElement(By.id(id));
            element.clear();
            element.sendKeys(content);
        } catch (Exception e) {
            System.out.println("定位元素，输入失败");
            throw new RuntimeException(e);
        }

    }


    //进行点击的方法
    public void multiClick(String type, String locator) {
        try {
            switch (type) {
                case "id": {
                    driver.findElement(By.id(locator)).click();
                    ;
                }
                case "css": {
                    driver.findElement(By.cssSelector(locator)).click();
                }
                case "xpath": {
                    driver.findElement(By.xpath(locator)).click();
                }
            }
        } catch (Exception e) {
            System.out.println("点击元素失败");
            throw new RuntimeException(e);
        }

    }


    //form表单提交数据的方法
    public void submit(String xpath) {
        driver.findElement(By.xpath(xpath)).submit();

    }

    //设置隐式等待时长
    public void implicitlyWait(String times){
        double d = Double.parseDouble(times);
        driver.manage().timeouts().implicitlyWait((long) d*1000, TimeUnit.MILLISECONDS);

    }

    //设置显式等待时长
    public void explicitWait(String content){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.titleContains(content));


    }


    //设置强制等待时长
    public void halt(String times) throws InterruptedException {
        try {
            double d = Double.parseDouble(times);
            Thread.sleep((long) (d*1000));
        } catch (NumberFormatException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    //使用js来完成点击操作
    public void jsClick(String cssSelector){
        try {
            String js="document.querySelector('"+cssSelector+"').click()";
            JavascriptExecutor jsExe=(JavascriptExecutor) this.driver;
            jsExe.executeScript(js);
        } catch (Exception e) {
            System.out.println("执行JS语句失败");
            throw new RuntimeException(e);
        }
    }



    //浏览器关闭的方法
    public void closeBrowser() {
        driver.quit();
    }


    //断言
    //获取元素的文本断言
    public void assertEleText(String xpath, String containText) {
        String actualText = driver.findElement(By.xpath(xpath)).getText();
        if (actualText.toLowerCase().contains(containText)) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }

    }

    //获取标题进行断言
    public boolean assertTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("测试通过");
            return true;
        } else {
            System.out.println("测试失败");
            return false;
        }

    }

    //获取网页源码进行断言
    public void assertSource(String containText){
        String actualPageSource = driver.getPageSource();
        if (actualPageSource.contains(containText)){
            System.out.println("测试通过");
        }else {
            System.out.println("测试失败");

        }

    }

    //获取url进行断言
    public void assertUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
//        System.out.println(actualUrl);
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }

    }

    //获取元素属性值进行断言
    public void assertAttribute(String xpath, String attribute, String expectedAttributeValue) {
        String actualAttributeValue = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
//        System.out.println(actualAttributeValue);
        if (expectedAttributeValue.equals(actualAttributeValue)) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }


}
