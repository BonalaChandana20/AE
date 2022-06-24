package Tests;

import Pages.AllocationPage;
import org.testng.annotations.Test;

public class AllocationPageTest extends BaseClass {
    AllocationPage Ap = new AllocationPage();

    @Test
    public void TC07_VerifyStatusOfPod(){

        Ap.verify_StatusOfPod();

    }
    @Test
    public void TC08_VerifyStatusOfPodAfterNominate() throws InterruptedException {

        Ap.click_nominateTab().
                click_nominateButton().
                click_AddingHaSher().
                click_ConfirmNomination().
                click_allocationsTab().
                click_Confirm().
                verify_StatusAfterNominate();

    }
    @Test
    public void TC09_VerifyAddingHaSher() throws InterruptedException {

        Ap.click_nominateTab().
                click_nominateButton().
                click_AddingHaSher().
                click_ConfirmNomination();
    }
    @Test
    public void TC10_VerifyFilterOption() throws InterruptedException {

        Ap.click_nominateTab().
                click_nominateButton().
                click_Filter().
                click_ApplyButton().
                Verify_TheFilter();

    }
    @Test
    public void TC21_verifyStatusAfterSaveConfiguration() throws InterruptedException{

        Ap.click_UpcomingPods().
                verify_StatusAfterConfigureThePod();
    }


}
