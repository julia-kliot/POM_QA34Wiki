package tests;

import manage.ConfigurationWiki;
import manage.DataProviderWiki;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class Login extends ConfigurationWiki {

@Test
    public void login1(){
    Auth auth= Auth.builder().userName("juliakliot.jk").password("Misha240613").build();
    boolean isLogged= new MainScreen(driver)
            .clickOnFlowBtton()
            .clickOnLoginWikiButton()
            .fillInLoginForm(auth)
            .clickOnFlowBtton()
            .isLogged();
    Assert.assertTrue(isLogged);
}
    @Test
    public void login2(){

        boolean isLogged= new MainScreen(driver)
                .clickOnFlowBtton()
                .clickOnLoginWikiButton()
                .fillInLoginForm2("uliakliot.jk","Misha240613")
                .clickOnFlowBtton()
                .isLogged();
        Assert.assertTrue(isLogged);
    }

    @Test
    public void login3(){
        Auth auth= Auth.builder().userName("juliakliot.jk").password("Misha240613").build();
        new MainScreen(driver)
                .clickOnFlowBtton()
                .clickOnLoginWikiButton()
                .fillInLoginForm(auth)
                .clickOnFlowBtton()
                .logOut();

    }
    @Test(dataProvider = "logInData", dataProviderClass = DataProviderWiki.class)
    public void login4(){
    logger.info("Starts login model---");
    String inf =new MainScreen(driver)
            .clickOnFlowBtton()
            .clickOnLoginWikiButton()
            .fillInLoginForm(Auth.builder().userName("").password("Misha240613").build())
            .clickOnFlowBtton()
            .logOut()
            .clickOnFlowBtton()
            .getInf();

    Assert.assertEquals(inf,"Log in to Wikipedia");
    }

    @Test(dataProvider = "logDataCsv", dataProviderClass = DataProviderWiki.class)
    public void login5(){
    logger.info("Starts login without model---");
        String inf =new MainScreen(driver)
                .clickOnFlowBtton()
                .clickOnLoginWikiButton()
                .fillInLoginForm2("juliakliot.jk","Misha240613")
                .clickOnFlowBtton()
                .logOut()
                .clickOnFlowBtton()
                .getInf();

        Assert.assertEquals(inf,"Log in to Wikipedia");
    }

}
