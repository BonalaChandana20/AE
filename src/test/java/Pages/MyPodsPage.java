package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MyPodsPage extends BaseClass {



    //Locators
    By MyPodsTab = By.xpath("//span[contains(text(),'My Pods')]");
    By StatusOfPod = By.xpath("//span[contains(text(),'ALLOCATION READY')]");
    By podTab = By.xpath("//span[contains(text(),'POD-515')]");
    By nominateTab = By.xpath("//span[contains(text(),'POD-488')]");
    By MessageBeforeNominate = By.xpath("//div[@class='message-for-allocation-ready']");
    By nominateButton = By.xpath("//*[@class='ant-tag' and contains(text(),'Python')]");
    By addingHaSher = By.xpath("(//span[@class='anticon anticon-user-add'])[2]");
    By confirmNominationButton = By.xpath("//Span[contains(text(),'Confirm Nominations')]");
    By confirmButton = By.xpath("//span[contains(text(),'Yes, Confirm')]");
    By statusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By resetButton = By.xpath("//span[contains(text(),'Reset')]");
    By selectBands = By.xpath("(//div[@class='ant-select-selector'])[3]");
    By FilterOption = By.xpath("//span[@class='ant-badge']");
    By Band = By.xpath("(//p[text()=\"Bands\"])//following::input[@type=\"search\"][1]");
    By applyButton = By.xpath("//span[contains(text(),'Apply')]");
    By addingHaSher1 = By.xpath("(//span[@class='anticon anticon-user-add'])[1]");
    By myPodsNomination = By.xpath("//Span[@class='nomination-with-count']");
    By searchButton =  By.xpath("(//input[@type='search'])[2]");
    By confidenceLevel = By.xpath("//div[@title='High']");
    By CommentsField = By.xpath("//textarea[@class='ant-input']");
    By checkBox = By.xpath("//span[@class='anticon anticon-check-circle']");
    By consideredStatus = By.xpath("//span[contains(text(),'Considered')]");
    By RespondedStatus = By.xpath("//span[contains(text(),'Responded')]");


    //Page Actions

    public MyPodsPage click_MyPods(){
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(MyPodsTab)).click().perform();
       // driver.findElement(MyPodsTab).click();
        return this;
    }
    public MyPodsPage verify_NewPods(){
        String Status = driver.findElement(StatusOfPod).getText();
        System.out.println("Status of New Pod Under open pods tab in PO dashboard:"+" "+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;
    }
    public MyPodsPage click_PodTab() throws InterruptedException {
        do_click(podTab);
        return this;
    }
    public MyPodsPage Verify_Message(){
        String Message = driver.findElement(MessageBeforeNominate).getText();
        System.out.println("message before Starting the Nomination:"+" "+Message);
        Assert.assertEquals(Message,"Waiting for Allocation Owner to start nominating Hashers");
        return this;
    }
    public MyPodsPage click_NominateTab() throws InterruptedException {
        do_click(nominateTab);
       // driver.findElement(nominateTab).click();
        return this;
    }
    public MyPodsPage click_NominateButton() throws InterruptedException {
        do_click(nominateButton);
      //  driver.findElement(nominateButton).click();
        return this;

    }
    public MyPodsPage click_AddingHaSher() throws InterruptedException {
        do_click(addingHaSher);
       // driver.findElement(addingHaSher).click();
        return this;
    }
    public MyPodsPage click_ConfirmNominationButton() throws InterruptedException {
        do_click(confirmNominationButton);
        //driver.findElement(confirmNominationButton).click();
        return this;
    }
    public MyPodsPage click_ConfirmButton() throws InterruptedException {
        do_click(confirmButton);

        //driver.findElement(confirmButton).click();
        return this;
    }
    public MyPodsPage Verify_StatusAfterNominating(){
        String Status = driver.findElement(statusOfPodAfterNominate).getText();
        System.out.println("Status of pod After Nominating under OpenPods tab on PO dashBoard :"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public MyPodsPage click_OnFilter() throws InterruptedException {
        // Thread.sleep(4000);
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(FilterOption)));
        js_click(FilterOption);
       // driver.findElement(FilterOption).click();
        return this;
    }
    public MyPodsPage click_ResetButton() throws InterruptedException {
        do_click(resetButton);
       // driver.findElement(resetButton).click();
        return this;
    }
    public MyPodsPage SelectBand(){
        driver.findElement(selectBands).click();
        return this;
    }
    public MyPodsPage click_Band(){
        WebElement yourOption = driver.findElement(Band);
        yourOption.sendKeys(prop.getProperty("Band"));
        yourOption.sendKeys(Keys.RETURN);
        return this;
    }
    public MyPodsPage click_ApplyButton() throws InterruptedException {
        do_click(applyButton);
       // driver.findElement(applyButton).click();
        return this;
    }
    public MyPodsPage click_AddingHaSher1() throws InterruptedException {
        do_click(addingHaSher1);
       // driver.findElement(addingHaSher1).click();
        return this;

    }
    public MyPodsPage WaitUntilStatusChange() throws InterruptedException {
      Thread.sleep(3*60*1000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        return this;
    }
    public MyPodsPage click_MyPodsNomination() throws InterruptedException {
        do_click(myPodsNomination);
       // driver.findElement(myPodsNomination).click();
        return this;
    }
    public MyPodsPage click_SearchOption() throws InterruptedException {
        do_click(searchButton);
       // driver.findElement(searchButton).click();
        return this;
    }
    public MyPodsPage provide_ConfidenceLevel() throws InterruptedException {
        do_click(confidenceLevel);
       // driver.findElement(confidenceLevel).click();
        return this;
    }
    public MyPodsPage Comments() throws InterruptedException {
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element')");
       // Thread.sleep(4000);
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(CommentsField)));
        WebElement ele = driver.findElement(CommentsField);
        ele.sendKeys(prop.getProperty("Comments"));
        return this;
    }
    public MyPodsPage click_CheckBox() throws InterruptedException {
        do_click(checkBox);
       // driver.findElement(checkBox).click();
        return this;
    }

    public MyPodsPage Verifying_TheConsideredStatus(){
        String Status = driver.findElement(consideredStatus).getText();
        System.out.println("Status After Complete the Nomination is:"+" "+Status);
        Assert.assertEquals(Status,"CONSIDERED");
        return this;
    }
    public MyPodsPage Verify_StatusResponded(){
        String Status = driver.findElement(RespondedStatus).getText();
        System.out.println("Status After giving Confidence Level:"+" "+Status);
        Assert.assertEquals(Status,"RESPONDED");
        return this;
    }

}
