package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public  class Allocate extends BaseClass {



    //page locators

    //Common X-paths

    By nominate_btn = By.xpath("//tr[contains(@class,\"row-level-0 pointer\")][1]");
    By add_hasher = By.xpath("(//span[@class='anticon anticon-user-add'])[1]");
    By ConfirmNominationButton = By.xpath("//span[contains(text(),'Confirm Nominations')]");
    By confirm_pod = By.xpath("//span[contains(text(),'Yes, Confirm')]");
    By AllocationTab = By.xpath("//span[contains(text(),'Allocations')]");
    By filter = By.xpath("//span[@class='ant-badge']");
    By apply_btn = By.xpath("//span[contains(text(),'Apply')]");
    By reset_Btn = By.xpath("//span[contains(text(),'Reset')]");


    //Chandana X-paths
    By SkillInFilter = By.xpath("//*[@class='ant-select-selection-item-content']");
    By SkillInWebPage = By.xpath("//*[@class='ant-tag']");
    By UpcomingPodsTab = By.xpath("//div[@id='rc-tabs-0-tab-upcomingPods']");
    By StatusOfUpcomingPod = By.xpath("//span[contains(text(),'UPCOMING')]");
    By StatusOfPod = By.xpath("//span[@data-status='ALLOCATION_READY']");
    By StatusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By selectBands = By.xpath("(//div[@class='ant-select-selector'])[3]");
    By Band = By.xpath("(//p[text()=\"Bands\"])//following::input[@type=\"search\"][1]");

    //Page Actions


    public Allocate click_allocationsTab() throws InterruptedException {
        do_click(AllocationTab);
        return this;
    }
    public Allocate click_pod(String pod)  throws InterruptedException {
        new WebDriverWait(driver, 5).
                until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
        driver.navigate().refresh();

        do_click(By.xpath("//span[text()=\""+pod+"\"]"));

        return  this;
    }
    public Allocate click_nominate_btn() throws InterruptedException {
        do_click(nominate_btn);
        return this;
    }
    public String get_StatusOfPod() {

        return driver.findElement(StatusOfPod).getText();
    }
    public Allocate verify_StatusOfPod(){
        String Status= get_StatusOfPod();
        System.out.println("Status of pod:"+""+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;

    }

    public Allocate click_Confirm() throws InterruptedException {
        do_click(confirm_pod);
        return this;
    }

    public String get_StatusAfterNominate() throws InterruptedException {

        return driver.findElement(StatusOfPodAfterNominate).getText();
    }
    public Allocate verify_StatusAfterNominate() throws InterruptedException {

        String Status = get_StatusAfterNominate();
        System.out.println("Status of pod After Nominate:"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public Allocate click_add_hasher() throws InterruptedException {
        do_click(add_hasher);
       return this;

    }
    public Allocate click_ConfirmNomination() throws InterruptedException {
        do_click(ConfirmNominationButton);
        return this;
    }
    public Allocate click_filter() throws InterruptedException {
        js_click(filter);
        return this;
    }

    public Allocate click_apply() throws InterruptedException {
        Thread.sleep(4000);
        //js_click(applyButton);
        driver.findElement(apply_btn).click();
        return this;
    }
    public String SkillFilter() {

        driver.findElement(SkillInFilter).isDisplayed();
        return driver.findElement(SkillInFilter).getText();
    }
    public String SkillWebpage(){

        return driver.findElement(SkillInWebPage).getText();
    }
    public Allocate Verify_TheFilter()  {

        String SkillInFilter = SkillFilter();
        String SkillInWebPage = SkillWebpage();
        System.out.println("Skill in Filter:"+" "+SkillInFilter);
        System.out.println("Skill in WebPage:"+" "+SkillInWebPage);
        Assert.assertEquals(SkillInFilter,SkillInWebPage);
        return this;
    }
    public Allocate click_UpcomingPods() throws InterruptedException {
        do_click(UpcomingPodsTab);
        return this;

    }
    public Allocate verify_StatusAfterConfigureThePod(){

        String Status = driver.findElement(StatusOfUpcomingPod).getText();
        System.out.println("Status After Configuration :"+" "+Status);
        Assert.assertEquals(Status,"UPCOMING");
        return this;


    }
    public Allocate click_ResetButton() throws InterruptedException {
        do_click(reset_Btn);
        return this;
    }
    public Allocate SelectBand(){
        driver.findElement(selectBands).click();
        return this;
    }
    public Allocate click_Band(){
        WebElement yourOption = driver.findElement(Band);
        yourOption.sendKeys(prop.getProperty("Band"));
        yourOption.sendKeys(Keys.RETURN);
        return this;
    }


}
