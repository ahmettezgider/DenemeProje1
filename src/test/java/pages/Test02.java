package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.IMethodInstance;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Test02 {

    @Test
    public void test1(){

        By userName = By.cssSelector("input#txtUsername");
        By password = By.cssSelector("input#txtPassword");
        By submitButton = By.cssSelector("input#btnLogin");



        String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        Configuration.startMaximized = true;
        open(url);
        $(userName).shouldBe(Condition.appear).setValue("Admin");
        $(password).scrollTo().setValue("admin123").pressEnter();
        //$(submitButton).click();

        $("a#welcome").shouldBe(Condition.visible);
        System.out.println($("body").getText());



    }


    @Test
    public void test2(){
        open("http://opencart.abstracta.us/");
        String str = $("div.product-thumb",1).shouldBe(Condition.visible).getText();
        System.out.println(str);
    }

    @Test
    public void test3(){
        open("http://opencart.abstracta.us/");
        for (SelenideElement e : $$("div.product-thumb")) {
            System.out.println(e.getText());
            System.out.println("-----------------");
        }

        for (int i = 0; i < $$("div.product-thumb").size(); i++) {
            System.out.println($$("div.product-thumb").get(i).getText());
        }

        $$("div.product-thumb").forEach(e -> System.out.println(e.getText()));
    }

    @Test
    public void test4(){
        open("http://opencart.abstracta.us/");
        $$("div.product-thumb")
                .filter(Condition.text("an"))
                .forEach(e -> {
                    System.out.println(e);
                    System.out.println("---------");
                });


        /*
        $$("div.product-thumb")
                .filter(Condition.text("an"))
                .forEach(e -> {
                    System.out.println(e);
                    System.out.println("---------");
                });


        $$("div.product-thumb")
                .filter(Condition.text("an"))
                .forEach(e->yaz(e));

        $$("div.product-thumb")
                .filter(Condition.text("an"))
                .forEach(System.out::println);
        */
    }

    public void yaz(SelenideElement e){
        System.out.println(e.getText());
        System.out.println("--------");
    }

}
