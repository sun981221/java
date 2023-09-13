package com.testing.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @program: WebAutoTest
 * @ClassName test
 * @description: chrome启动配置
 * @author: Sun
 * @create: 2023-09-11 22:34
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) throws InterruptedException {

        // 设置 ChromeDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // 创建 ChromeOptions 对象
        ChromeOptions options = new ChromeOptions();

        //设置临时环境变量，指定chrome使用静默模式，减少日志输出量
        System.setProperty("web-driver.chrome.silentOutput", "true");

        //使用个人信息
//        options.addArguments("--user-data-dir=/Users/sun/Desktop/Chrome");

        // 禁用 Chrome 的提示栏
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "load-extension"});

        //窗口最大化
        options.addArguments("--start-maximized");


        // 启动 Chrome 浏览器并传递 ChromeOptions
        WebDriver driver = new ChromeDriver(options);



        // 执行自动化测试代码
        driver.get("https://www.baidu.com");

        Thread.sleep(3000);

        // 关闭浏览器
        driver.quit();
    }
}

