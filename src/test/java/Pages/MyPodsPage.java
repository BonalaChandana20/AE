package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

    public MyPodsPage MyPods(){
        driver.findElement(MyPodsTab).click();
        return this;
    }
    public MyPodsPage VerifyNewPods(){
        String Status = driver.findElement(StatusOfPod).getText();
        System.out.println("Status of New Pod Under open pods tab in PO dashboard:"+" "+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;
    }
    public MyPodsPage PodTab(){
        driver.findElement(podTab).click();
        return this;
    }
    public MyPodsPage VerifyMessage(){
        String Message = driver.findElement(MessageBeforeNominate).getText();
        System.out.println("message before Starting the Nomination:"+" "+Message);
        Assert.assertEquals(Message,"Waiting for Allocation Owner to start nominating Hashers");
        return this;
    }
    public MyPodsPage NominateTab(){
        driver.findElement(nominateTab).click();
        return this;
    }
    public MyPodsPage NominateButton(){
        driver.findElement(nominateButton).click();
        return this;

    }
    public MyPodsPage AddingHaSher(){
        driver.findElement(addingHaSher).click();
        return this;
    }
    public MyPodsPage ConfirmNominationButton(){
        driver.findElement(confirmNominationButton).click();
        return this;
    }
    public MyPodsPage ConfirmButton(){
        driver.findElement(confirmButton).click();
        return this;
    }
    public MyPodsPage VerifyStatusAfterNominating(){
        String Status = driver.findElement(statusOfPodAfterNominate).getText();
        System.out.println("Status of pod After Nominating under OpenPods tab on PO dashBoard :"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public MyPodsPage Filter() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(FilterOption).click();
        return this;
    }
    public MyPodsPage ResetButton(){
        driver.findElement(resetButton).click();
        return this;
    }
    public MyPodsPage SelectBand(){
        driver.findElement(selectBands).click();
        return this;
    }
    public MyPodsPage Band(){
        WebElement yourOption = driver.findElement(Band);
        yourOption.sendKeys(prop.getProperty("Band"));
        yourOption.sendKeys(Keys.RETURN);
        return this;
    }
    public MyPodsPage ApplyButton() throws InterruptedException {
        driver.findElement(applyButton).click();
        return this;
    }
    public MyPodsPage AddingHaSher1(){
        driver.findElement(addingHaSher1).click();
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
    public MyPodsPage MyPodsNomination(){
        driver.findElement(myPodsNomination).click();
        return this;
    }
    public MyPodsPage SearchOption(){
        driver.findElement(searchButton).click();
        return this;
    }
    public MyPodsPage ConfidenceLevel(){
        driver.findElement(confidenceLevel).click();
        return this;
    }
    public MyPodsPage Comments() throws InterruptedException {
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element')");
        Thread.sleep(4000);
        WebElement ele = driver.findElement(CommentsField);
        ele.sendKeys(prop.getProperty("Comments"));
        return this;
    }
    public MyPodsPage CheckBox(){
        driver.findElement(checkBox).click();
        return this;
    }

    public MyPodsPage VerifyingTheConsideredStatus(){
        String Status = driver.findElement(consideredStatus).getText();
        System.out.println("Status After Complete the Nomination is:"+" "+Status);
        Assert.assertEquals(Status,"CONSIDERED");
        return this;
    }
    public MyPodsPage VerifyStatusResponded(){
        String Status = driver.findElement(RespondedStatus).getText();
        System.out.println("Status After giving Confidence Level:"+" "+Status);
        Assert.assertEquals(Status,"RESPONDED");
        return this;
    }

}
