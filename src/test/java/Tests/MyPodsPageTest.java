package Tests;

import Pages.MyPodsPage;
import org.testng.annotations.Test;

public class MyPodsPageTest  extends BaseClass{
    MyPodsPage Mp = new MyPodsPage();

    @Test
    public void TC09_VerifyStatusOfPod(){

        Mp.click_MyPods().
                verify_NewPods();
    }

    @Test
    public void TC10_VerifyMessageBeforeNominating() throws InterruptedException {
        Mp.click_MyPods().
                click_PodTab().
                Verify_Message();
    }
    @Test
    public void TC11_VerifyStatusAfterNominate() throws InterruptedException {
        Mp.click_NominateTab().
                click_NominateButton().
                click_AddingHaSher().
                click_ConfirmNominationButton().
                click_MyPods().
                click_ConfirmButton().
                Verify_StatusAfterNominating();
    }
    @Test
    public void TC13_VerifyConfidenceLevel() throws InterruptedException {
        Mp.click_NominateTab().
                click_NominateButton().
                click_OnFilter().
                click_ResetButton().
                click_Band().
                click_ApplyButton().
                click_AddingHaSher1().
                click_ConfirmNominationButton().
                click_MyPods().
                click_ConfirmButton().
                click_NominateTab().
                WaitUntilStatusChange().
                click_MyPodsNomination().
                Verifying_TheConsideredStatus().
                click_SearchOption().
                provide_ConfidenceLevel().Comments().click_CheckBox();
    }
    @Test
    public void TC14_VerifyStatusResponded() throws InterruptedException {
        Mp.click_MyPods().
                click_NominateTab().
                Verify_StatusResponded();


    }


}
