package com.migoo.democonsumers.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class TestChromDriver {
    /**
     * @param args
     */
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        //如果测试的浏览器没有安装在默认目录，那么必须在程序中设置
        //bug1:System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//Google//Chrome//Application//chrome.exe");
        //bug2:System.setProperty("webdriver.chrome.driver", "C://Users//Yoga//Downloads//chromedriver_win32//chromedriver.exe");
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

//            WebDriver driver = new ChromeDriver();
//            driver.get("https://www.baidu.com");
//            // 获取 网页的 title
//            System.out.println("The testing page title is: " + driver.getTitle());
//
//            driver.quit();



            ChromeOptions options=new ChromeOptions();
            options.setHeadless(true);
            ChromeDriver driver = new ChromeDriver(options);
//            driver.get("https://coronavirus.jhu.edu/map.html");
            driver.get("http://www.dajiuxing.com.cn/#/");
            new WebDriverWait(driver, 60).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            Thread.sleep(20000);
            String source = driver.getPageSource();
            System.out.println(" " + source);
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {

        //调用chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        //调用chrome
        ChromeDriver driver = new ChromeDriver();

        //调整高度
//        ((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //获取网址
        driver.get("https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_pc_1#tab4");

//       加载更多
        WebElement foreignTable = driver.findElement(By.id("foreignTable"));
        WebElement more = foreignTable.findElement(By.className("Common_1-1-253_3lDRV2"));
        try {
            more.click();
        }catch (Exception e){
            e.printStackTrace();
        }
        Thread.sleep(3000);
//
//        // table
        WebElement table = foreignTable.findElement(By.tagName("table"));
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> trs = tbody.findElements(By.tagName("tr"));
        if (trs != null && trs.size() > 0){
            WebElement td = trs.get(0).findElement(By.tagName("td"));
            WebElement stable = td.findElement(By.tagName("table"));
            WebElement stbody = stable.findElement(By.tagName("tbody"));
            List<WebElement> tr = stbody.findElements(By.tagName("tr"));
            for (WebElement t : tr) {
                List<WebElement> tdss = t.findElements(By.tagName("td"));
                WebElement titleEle = tdss.get(0);
                String titleSpan = titleEle.findElement(By.tagName("div")).getText();
                String addNum=tdss.get(1).getText();
                String nowNum=tdss.get(2).getText();
                String totleNum=tdss.get(3).getText();
                System.out.println(titleSpan+"--"+addNum+"--"+nowNum+"--"+totleNum);
            }
        }

//        //获取iframe元素内容直至tr
//        //获取tr
//        List<WebElement> tr = foreignTable.findElements(By.className("VirusTable_1-1-253_2AH4U9"));
//        for (WebElement t : tr) {
//            List<WebElement> tdss = t.findElements(By.tagName("td"));
////            String title = tdss.get(1).getText();
//            WebElement titleEle = tdss.get(0);
//            String titleSpan = titleEle.findElement(By.className("VirusTable_1-1-253_AcDK7v")).getText();
//            String addNum=tdss.get(1).getText();
//            String nowNum=tdss.get(2).getText();
//            String totleNum=tdss.get(3).getText();
//            System.out.println(titleSpan+"--"+addNum+"--"+nowNum+"--"+totleNum);
//        }
        //关闭driver
        driver.close();
    }

    public static void main2(String args[]) throws Exception {

        //调用chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        //调用chrome
        WebDriver driver = new ChromeDriver();

        //调整高度
        ((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //获取网址
        ((ChromeDriver) driver).get("http://epub.cnki.net/KNS/brief/result.aspx?dbprefix=CMFD");

        //高级搜索
        WebElement high = driver.findElement(By.xpath("//*[@id=\"1_3\"]/a"));
        high.click();
        Thread.sleep(1000);
        //定位元素
        WebElement in = ((ChromeDriver) driver).findElementByName("txt_1_value1");

        //定义搜索内容
        String searchWord = "";
        searchWord = "基因芯片";
        //发送搜索内容
        in.sendKeys(searchWord);
        ((ChromeDriver) driver).findElementByXPath("//*[@id='ddSubmit']/span").click();
        ((ChromeDriver) driver).findElementByXPath("//*[@id='btnSearch']").click();
        Thread.sleep(2000);
        //清除分类获得所有
        ((ChromeDriver) driver).findElementByXPath("//*[@id='XuekeNavi_Div']/div[1]/input[1]").click();
        ((ChromeDriver) driver).findElementByXPath("//*[@id='B']/span/img[1]").click();
        Thread.sleep(2000);

        //分割符
        System.out.println("-----------------------");

        //定位iframe
        WebElement iframe = driver.findElement(By.id("iframeResult"));

        //也可直接这样写((ChromeDriver) driver).switchTo().frame("id=iframeResult");

        //线程休眠
        Thread.sleep(2000);



        for (int i = 0; i <10; i++) {
            //获取窗口
            String now_handle = driver.getWindowHandle();
            Set<String> all_handles = driver.getWindowHandles();
            //判断窗口是否一致
            for (String handle : all_handles) {
                if (handle != now_handle) {
                    driver.switchTo().window(handle);
                    ((ChromeDriver) driver).switchTo().frame(iframe);

                    //选择50页
                    WebElement btn = ((ChromeDriver) driver).findElementByXPath("//*[@id=\"id_grid_display_num\"]/a[3]");
                    btn.click();

                    //获取页面内容
                    //String content=driver.getPageSource();
                    //System.out.println(content);

                    //获取iframe元素内容直至tr
                    List<WebElement> tb = driver.findElements(By.xpath("//*[@id=\"ctl00\"]/table/tbody/tr[2]"));
                    for (WebElement t : tb) {
                        List<WebElement> tbod = t.findElements(By.tagName("tbody"));
                        for (WebElement tr : tbod) {
                            List<WebElement> td = tr.findElements(By.tagName("tr"));
                            td.remove(0);
                            for (WebElement tds : td) {
                                List<WebElement> tdss = tds.findElements(By.tagName("td"));
                                String title = tdss.get(1).getText();
                                String author=tdss.get(2).getText();
                                String college=tdss.get(3).getText();
                                String year=tdss.get(4).getText();
                                System.out.println(title+"--"+author+"--"+college+"--"+year);
                            }
                        }

                    }


                }
            }
            //线程休眠
            Thread.sleep(1000);
            WebElement nextBtn=((ChromeDriver) driver).findElementByXPath("//*[@id=\"Page_next\"]");
            nextBtn.click();
        }


        //关闭driver
        driver.close();
    }
}
