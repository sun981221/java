package com.testing.class2;

import com.testing.web.WebKeyWord;

/**
 * @program: WebAutoTest
 * @ClassName WebKwTest
 * @description:
 * @author: Sun
 * @create: 2023-09-11 23:37
 * @Version 1.0
 **/
public class WebKwTest {
    public static void main(String[] args) throws InterruptedException {
        WebKeyWord web = new WebKeyWord();
        try {
            /**
             *          web.openBrowser("chrome");
             * //            web.implicitlyWait("10");
             *             web.visitWeb("https://www.baidu.com");
             *             web.visitWeb("https://www.51job.com");
             *             web.forwardOrBackOrRefresh("fresh");
             *             web.forwardOrBackOrRefresh("back");
             *             web.inputById("kw", "test");
             *             web.submit("//*[@id=\"su\"]");
             *             web.inputById("kw", "huawei");
             *             web.halt("1");
             * //            web.multiClick("xpath", "//*[@id='su']");
             *             web.jsClick("[value=\"百度一下\"]");
             *             web.assertEleText("//*[@id=\"2\"]/div/div[1]/h3/a[1]", "华为");
             *             web.assertSource("huawei");
             *             web.assertTitle("huawei");
             * //            web.assertAttribute("//*[@id=\"3001\"]/div/div[1]/div/div/h3/div/a", "style", "display: inline !important; visibility: visible !important;");
             *             web.assertUrl("www.baidu.com");
             */
            web.openBrowser("chrome");
            web.implicitlyWait("10");
            web.visitWeb("https://www.jd.com");
            web.hover("//*[@id=\"J_cate\"]/ul/li[5]/a[2]");
            web.halt("5");




        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            web.closeBrowser();
        }


    }
}
