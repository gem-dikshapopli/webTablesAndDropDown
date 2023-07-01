package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;




public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Diksha.Popli/Downloads/Dropdown.html");
        Locators locators=new Locators();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.manage().window().maximize();

            //-----------------Select date 05-May-2005 drom the dropdown and validate the same.-----//
            driver.findElement(By.xpath(locators.day)).click();
            Select date=new Select(driver.findElement(By.xpath(locators.day)));
            date.selectByValue("05");
            driver.findElement(By.xpath(locators.month)).click();
            Select month=new Select(driver.findElement(By.xpath(locators.month)));
            month.selectByValue("05");
            driver.findElement(By.xpath(locators.year)).click();
            Select year=new Select(driver.findElement(By.xpath(locators.year)));
            year.selectByValue("2005");

            String finalDate=date.getFirstSelectedOption().getText()+"-"+month.getFirstSelectedOption().getText()+"-"+year.getFirstSelectedOption().getText();
            if(finalDate.equals("05-May-2005")){
                System.out.println("validated");
            }
            else {
                System.out.println("Not validated");
            }

            Thread.sleep(2000);

        //---------------------etch the year from the dropdown and validate the year is in Ascending Order.--------------//


            boolean bool=true;
            for(int i=3;i<year.getOptions().size()-1;i++){
                String str=driver.findElement(By.xpath("(//select[@id='dob-year']//option)["+i+"]")).getText();
                String str1=driver.findElement(By.xpath("(//select[@id='dob-year']//option)["+i+"]")).getText();

                int a=Integer.parseInt(str);
                int b=Integer.parseInt(str1);

                if(a<b){
                    bool=false;
                    break;
                }

            }
            System.out.println(bool);
           Thread.sleep(2000);

        }catch (Exception e){
            System.out.println(e);
        }
        driver.close();
    }
}