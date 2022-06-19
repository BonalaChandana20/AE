package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;

public  class AllocationPage extends BaseClass {



    //page locators

    By StatusOfPod = By.xpath("//span[@data-status='ALLOCATION_READY']");
    By StatusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By NominateTab = By.xpath("//span[contains(text(),'POD-456')]");
    By NominateButton = By.xpath("//*[@class='ant-tag' and contains(text(),'Java')]");
    By addingHaSher = By.xpath("(//span[@class='anticon anticon-user-add'])[2]");
    By ConfirmNominationButton = By.xpath("//Span[contains(text(),'Confirm Nominations')]");
    By ConfirmButton = By.xpath("//span[contains(text(),'Yes, Confirm')]");
    By AllocationTab = By.xpath("//span[contains(text(),'Allocations')]");
    By FilterOption = By.xpath("//span[@class='ant-badge']");
    By applyButton = By.xpath("//span[contains(text(),'Apply')]");
    By SkillInFilter = By.xpath("//*[@class='ant-select-selection-item-content']");
    By SkillInWebPage = By.xpath("(//*[@class='ant-tag' and contains(text(),'Java')])[2]");
    By UpcomingPodsTab = By.xpath("//div[@id='rc-tabs-0-tab-upcomingPods']");
    By StatusOfUpcomingPod = By.xpath("//span[contains(text(),'UPCOMING')]");

    //Page Actions

    public String getStatusOfPod() {

        return driver.findElement(StatusOfPod).getText();
    }
    public AllocationPage verifyStatusOfPod(){
        String Status= getStatusOfPod();
        System.out.println("Status of pod:"+""+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;

    }
    public AllocationPage nominateTab() throws InterruptedException {

        driver.findElement(NominateTab).click();
        return this;
    }
    public AllocationPage nominateButton(){

        driver.findElement(NominateButton).click();
        return this;

    }
    public AllocationPage  allocationTab(){

        driver.findElement(AllocationTab).click();
        return this;
    }
    public AllocationPage Confirm(){
        driver.findElement(ConfirmButton).click();
        return this;
    }

    public String getStatusAfterNominate() throws InterruptedException {

        return driver.findElement(StatusOfPodAfterNominate).getText();
    }
    public AllocationPage verifyStatusAfterNominate() throws InterruptedException {

        String Status = getStatusAfterNominate();
        System.out.println("Status of pod After Nominate:"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public AllocationPage AddingHaSher() {

       driver.findElement(addingHaSher).click();
       return this;

    }
    public AllocationPage ConfirmNomination() {
        driver.findElement(ConfirmNominationButton);
        return this;
    }
    public AllocationPage Filter() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(FilterOption).click();
        return this;
    }
    public AllocationPage ApplyButton() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(applyButton).click();
        return this;

    }
    public String SkillFilter() {

        driver.findElement(SkillInFilter).isDisplayed();
        return driver.findElement(SkillInFilter).getText();
    }
    public String SkillWebpage(){

        return driver.findElement(SkillInWebPage).getText();
    }
    public AllocationPage VerifyTheFilter()  {

        String SkillInFilter = SkillFilter();
        String SkillInWebPage = SkillWebpage();
        System.out.println("Skill in Filter:"+" "+SkillInFilter);
        System.out.println("Skill in WebPage:"+" "+SkillInWebPage);
        Assert.assertEquals(SkillInFilter,SkillInWebPage);
        return this;
    }
    public AllocationPage UpcomingPods(){

        driver.findElement(UpcomingPodsTab).click();
        return this;

    }
    public AllocationPage StatusAfterConfigureThePod(){

        String Status = driver.findElement(StatusOfUpcomingPod).getText();
        System.out.println("Status After Configuration :"+" "+Status);
        Assert.assertEquals(Status,"UPCOMING");
        return this;


    }


}
