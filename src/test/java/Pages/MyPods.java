package Pages;

import Tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyPods extends BaseClass {



    //Locators

    By confidenceLevel = By.xpath("//div[@title='High']");
    By po_select = By.xpath("//span[@class='anticon anticon-check-circle']");
    By MyPodsTab = By.xpath("//span[contains(text(),'My Pods')]");
    By confirmNominationButton = By.xpath("//Span[contains(text(),'Confirm Nominations')]");
    By confirm_pod = By.xpath("//span[contains(text(),'Yes, Confirm')]");



    //Chandana X-paths
    By consideredStatus = By.xpath("//span[contains(text(),'Considered')]");
    By RespondedStatus = By.xpath("//span[contains(text(),'Responded')]");
    By StatusOfPod = By.xpath("//span[contains(text(),'ALLOCATION READY')]");
    By statusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By CommentsField = By.xpath("//textarea[@class='ant-input']");
    By searchButton =  By.xpath("(//input[@type='search'])[2]");
    By myPodsNomination = By.xpath("//Span[@class='nomination-with-count']");
    By MessageBeforeNominate = By.xpath("//div[@class='message-for-allocation-ready']");

    //Page Actions

    public MyPods click_MyPods(){
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(MyPodsTab)).click().perform();
       // driver.findElement(MyPodsTab).click();
        return this;
    }
    public MyPods verify_NewPods(){
        String Status = driver.findElement(StatusOfPod).getText();
        System.out.println("Status of New Pod Under open pods tab in PO dashboard:"+" "+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;
    }
    public MyPods click_pod(String pod) throws InterruptedException {
        new WebDriverWait(driver, 5).
                until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
        driver.navigate().refresh();

        do_click(By.xpath("//span[text()=\""+pod+"\"]"));

        return this;
    }

    public MyPods Verify_Message(){
        String Message = driver.findElement(MessageBeforeNominate).getText();
        System.out.println("message before Starting the Nomination:"+" "+Message);
        Assert.assertEquals(Message,"Waiting for Allocation Owner to start nominating Hashers");
        return this;
    }
//    public MyPods click_NominateTab() throws InterruptedException {
//        do_click(nominateTab);
//       // driver.findElement(nominateTab).click();
//        return this;
//    }
//    public MyPods click_NominateButton() throws InterruptedException {
//        do_click(nominateButton);
//      //  driver.findElement(nominateButton).click();
//        return this;

//    }
//    public MyPods click_AddingHaSher() throws InterruptedException {
//        do_click(addingHaSher);
//       // driver.findElement(addingHaSher).click();
//        return this;
//    }
    public MyPods click_ConfirmNominationButton() throws InterruptedException {
        do_click(confirmNominationButton);
        //driver.findElement(confirmNominationButton).click();
        return this;
    }
    public MyPods click_ConfirmButton() throws InterruptedException {
        do_click(confirm_pod);

        //driver.findElement(confirmButton).click();
        return this;
    }
    public MyPods Verify_StatusAfterNominating(){
        String Status = driver.findElement(statusOfPodAfterNominate).getText();
        System.out.println("Status of pod After Nominating under OpenPods tab on PO dashBoard :"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
//    public MyPods click_OnFilter() throws InterruptedException {
//        // Thread.sleep(4000);
//       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(FilterOption)));
//        js_click(FilterOption);
//       // driver.findElement(FilterOption).click();
//        return this;
//    }


//    public MyPods click_ApplyButton() throws InterruptedException {
//        do_click(applyButton);
//       // driver.findElement(applyButton).click();
//        return this;
//    }
//    public MyPods click_AddingHaSher1() throws InterruptedException {
//        do_click(addingHaSher1);
//       // driver.findElement(addingHaSher1).click();
//        return this;
//
//    }
    public MyPods wait_for_consideration() throws InterruptedException {
      Thread.sleep(3*60*1000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        return this;
    }
    public MyPods click_MyPodsNomination() throws InterruptedException {
        do_click(myPodsNomination);
       // driver.findElement(myPodsNomination).click();
        return this;
    }
    public MyPods click_SearchOption() throws InterruptedException {
        do_click(searchButton);
       // driver.findElement(searchButton).click();
        return this;
    }
    public MyPods provide_ConfidenceLevel() throws InterruptedException {
        do_click(confidenceLevel);
        return this;
    }
    public MyPods Comments() throws InterruptedException {
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element')");
       // Thread.sleep(4000);
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(CommentsField)));
        WebElement ele = driver.findElement(CommentsField);
        ele.sendKeys(prop.getProperty("Comments"));
        return this;
    }
    public MyPods select_hasher() throws InterruptedException {
        do_click(po_select);
        return this;
    }

    public MyPods Verifying_TheConsideredStatus(){
        String Status = driver.findElement(consideredStatus).getText();
        System.out.println("Status After Complete the Nomination is:"+" "+Status);
        Assert.assertEquals(Status,"CONSIDERED");
        return this;
    }
    public MyPods Verify_StatusResponded(){
        String Status = driver.findElement(RespondedStatus).getText();
        System.out.println("Status After giving Confidence Level:"+" "+Status);
        Assert.assertEquals(Status,"RESPONDED");
        return this;
    }

}
