package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Iterator;

public class UniqueRows {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("C:\\Users\\Diksha.Popli\\Downloads\\Assignment.html");
        HashMap uniqueElements=new HashMap<>();
        try {
            for(int i=2;i<=18;i++){
                String str1=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
                int count=0;
                for(int j=2;j<=17;j++){

                    if(i==j){
                        continue;
                    }
                    else{
                        String str2=driver.findElement(By.xpath("//table/tbody/tr["+j+"]/td[2]")).getText();
                        if(str1.equals(str2)){
                            count++;
                        }
                    }
                }
                if(count==0){
                    String name=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
                    uniqueElements.put(name,str1);
                }

            }
            System.out.println("--------------- Unique Rows in the Table---------------");
            for(Iterator iterator=uniqueElements.keySet().iterator(); iterator.hasNext();){
                String finalUniqueElements=(String) iterator.next();
                System.out.println(finalUniqueElements+" "+uniqueElements.get(finalUniqueElements));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.close();
    }
}
