package OrangeHRM;


import org.testng.annotations.Test;
import static OrangeHRM.Orange.*;


public class TestCases {


    @Test
    public void testLogin(){
        open();
        login("Admin", "admin123");

        //mainMenuHover();
        //orange.clickMenuTo("Recruitment");
        //orange.clickMenuTo("Time", "Reports", "Project Reports");
        clickMenuTo(MenuLinks.valueOf("ProjectReports"));
        //orange.clickMenuTo("Time", "Reports");




    }








}
