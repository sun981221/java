package com.testing.class1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        //启动浏览器驱动
//        WebDriverManager.chromedriver().setup();

        //创建一个浏览器参数对象
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("web-driver.chrome.driver", "chromedriver");

        //设置临时环境变量，指定chrome使用静默模式，减少日志输出量
        System.setProperty("web-driver.chrome.silentOutput", "true");
//        设置自动化启动时，不显示正在受到自动化软件控制的提示栏
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "load-extension"});
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--user-data-dir=/Users/sun/Documents/Software/chromedriver-mac-arm64/Chrome");
//

        //创建一个驱动对象
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            //最大化窗口
            driver.manage().window().maximize();

            //设置隐性等待时长
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //访问百度
            driver.get("http://www.baidu.com");
            Thread.sleep(1000);

            System.out.println("当前打开窗口的标题为：" + driver.getTitle());


            //切换到51job
            driver.navigate().to("http://51job.com");
            Thread.sleep(1000);
            System.out.println("当前打开窗口的标题为：" + driver.getTitle());


            //返回
            driver.navigate().back();
            Thread.sleep(1000);

            //刷新
            driver.navigate().refresh();
            Thread.sleep(1000);

            //输入框搜索华为mate60pro
            //id定位
            driver.findElement(By.id("kw")).sendKeys("华为mate60pro");
            //点击
            driver.findElement(By.id("su")).click();
//            driver.findElements(By.className("btn self-btn bg s_btn")).click();
            Thread.sleep(1000);


            //对元素进行操作
            WebElement ele = driver.findElement(By.id("kw"));
            ele.sendKeys("czy");
            Thread.sleep(1000);
            ele.clear();
            Thread.sleep(1000);
            ele.sendKeys("华为");
            Thread.sleep(1000);
            ele.submit();
            Thread.sleep(1000);

            //获取第三个搜索结果的标题
            String text = driver.findElement(By.xpath("//*[@id=\"2\"]/div/h3/a/div/div/p/span/span")).getText();
            System.out.println("当前搜索的第2个结果标题为：" + text);
            //获取属性值
            System.out.println(driver.findElement(By.xpath("//*[@id=\"2\"]/div/h3/a/div/div/p/span/span")).getAttribute("innerText"));


            //获取当前的url
            System.out.println("当前url为：" + driver.getCurrentUrl());

            //获取整个页面内容:driver.getPageSource()
            if (driver.getPageSource().toLowerCase().contains("华为")) {
                System.out.println(true);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        } finally {
            //关闭浏览器
            driver.quit();

            //关闭窗口
            // driver.quit();
        }


    }

}
