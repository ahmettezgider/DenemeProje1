package OrangeHRM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class Orange {

    private static final String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    private static final By username = By.cssSelector("input#txtUsername");
    private static final By password = By.cssSelector("input#txtPassword");
    private static final By loginButton = By.cssSelector("input#btnLogin");
    private static final By welcome = By.cssSelector("a#welcome");
    private static final By mainMenu = By.cssSelector("div#mainMenu");
    private static final By mainMenuXPath = By.xpath("//div[@id='mainMenu']");
    private static final By mainMenuLi = By.cssSelector("div#mainMenu > ul > li");

    public static void open(){
        Selenide.open(url);
    }

    public static void login(String user, String pass){
        $(username).shouldBe(Condition.appear).setValue(user);
        $(password).setValue(pass);
        $(loginButton).shouldBe(Condition.enabled).click();
        $(welcome).shouldBe(Condition.appear);
    }


    public static void mainMenuHover(){
        for (SelenideElement e : $$(mainMenuLi)) {
            e.hover();
            sleep(500);
        }

        $$(mainMenuLi).forEach(e->{
            e.hover();
            sleep(500);
        });
    }

    public static void clickMenuTo1(String...item){
        int clickIndex = item.length-1;
        String lastItem = item[clickIndex];
        for (int i = 0; i < clickIndex; i++) {
            $(mainMenu).find(byLinkText(item[i])).hover();
        }

        $(mainMenu).find(byLinkText(lastItem)).click();

    }

    public static void clickMenuTo(MenuLinks items){
        String lastItem = items.get(items.length()-1);
        String strXPath = "//div[@id='mainMenu']";
        for (int i = 0; i < items.length()-1; i++) {
            strXPath += "//li[.//a[text()='" + items.get(i) + "'] or .//b[text()='" + items.get(i) + "']]";
            $x(strXPath).hover();
        }
        $x(strXPath).find(byLinkText(lastItem)).click();
        //$(mainMenu).find(byLinkText(lastItem)).click();

    }



}
