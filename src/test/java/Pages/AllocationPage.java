package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;

public  class AllocationPage extends BaseClass {



    //page locators

    By StatusOfPod = By.xpath("//span[@data-status='ALLOCATION_READY']");
    By StatusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By NominateTab = By.xpath("//span[contains(text(),'POD-502')]");
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

    public String get_StatusOfPod() {

        return driver.findElement(StatusOfPod).getText();
    }
    public AllocationPage verify_StatusOfPod(){
        String Status= get_StatusOfPod();
        System.out.println("Status of pod:"+""+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;

    }
    public AllocationPage click_nominateTab()  throws InterruptedException {
        do_click(NominateTab);
        return this;
    }
    public AllocationPage click_nominateButton() throws InterruptedException {
        do_click(NominateButton);
        return this;

    }
    public AllocationPage click_allocationsTab() throws InterruptedException {
        do_click(AllocationTab);
        return this;
    }
    public AllocationPage click_Confirm() throws InterruptedException {
        do_click(ConfirmButton);
        return this;
    }

    public String get_StatusAfterNominate() throws InterruptedException {

        return driver.findElement(StatusOfPodAfterNominate).getText();
    }
    public AllocationPage verify_StatusAfterNominate() throws InterruptedException {

        String Status = get_StatusAfterNominate();
        System.out.println("Status of pod After Nominate:"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public AllocationPage click_AddingHaSher() throws InterruptedException {

        do_click(addingHaSher);
       return this;

    }
    public AllocationPage click_ConfirmNomination() throws InterruptedException {
        do_click(ConfirmNominationButton);
        return this;
    }
    public AllocationPage click_Filter() throws InterruptedException {

        js_click(FilterOption);
        return this;
    }
    public AllocationPage click_ApplyButton() throws InterruptedException {
        Thread.sleep(4000);
        //js_click(applyButton);
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
    public AllocationPage Verify_TheFilter()  {

        String SkillInFilter = SkillFilter();
        String SkillInWebPage = SkillWebpage();
        System.out.println("Skill in Filter:"+" "+SkillInFilter);
        System.out.println("Skill in WebPage:"+" "+SkillInWebPage);
        Assert.assertEquals(SkillInFilter,SkillInWebPage);
        return this;
    }
    public AllocationPage click_UpcomingPods() throws InterruptedException {
        do_click(UpcomingPodsTab);
        //driver.findElement(UpcomingPodsTab).click();
        return this;

    }
    public AllocationPage verify_StatusAfterConfigureThePod(){

        String Status = driver.findElement(StatusOfUpcomingPod).getText();
        System.out.println("Status After Configuration :"+" "+Status);
        Assert.assertEquals(Status,"UPCOMING");
        return this;


    }


}
