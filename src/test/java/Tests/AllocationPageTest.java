package Tests;

import Pages.AllocationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllocationPageTest extends BaseClass {
    AllocationPage Ap = new AllocationPage();

    @Test
    public void TC07_VerifyStatusOfPod(){

        Ap.verifyStatusOfPod();

    }
    @Test
    public void TC08_VerifyStatusOfPodAfterNominate() throws InterruptedException {

        Ap.nominateTab().nominateButton().AddingHaSher().ConfirmNomination().allocationTab().Confirm().verifyStatusAfterNominate();

    }
    @Test
    public void TC09_VerifyAddingHaSher() throws InterruptedException {

        Ap.nominateTab().nominateButton().AddingHaSher().ConfirmNomination();
    }
    @Test
    public void TC10_VerifyFilterOption() throws InterruptedException {

        Ap.nominateTab().nominateButton().Filter().ApplyButton().VerifyTheFilter();

    }
    @Test
    public void TC21_verifyStatusAfterSaveConfiguration() throws InterruptedException{

        Ap.UpcomingPods().StatusAfterConfigureThePod();
    }


}
