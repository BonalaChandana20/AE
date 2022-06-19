package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyPodsPage extends BaseClass {

    //Locators
    By MyPodsTab = By.xpath("//span[contains(text(),'My Pods')]");
    By StatusOfPod = By.xpath("//span[contains(text(),'ALLOCATION READY')]");
    By podTab = By.xpath("//span[contains(text(),'POD-502')]");
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
    By Band = By.xpath("(//div[@class='ant-select-item-option-content'])[3]");
    By applyButton = By.xpath("//span[contains(text(),'Apply')]");



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
        driver.findElement(Band).click();
        return this;
    }
    public void ApplyButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(applyButton).click();
    }

}
