package Tests;

import Pages.Allocate;
import Pages.Login;
import Pages.PodsPlatform;
import org.testng.annotations.Test;

public class AllocationPageTest extends BaseClass {
    Allocate AllocationOwner = new Allocate();
    Login login = new Login();
    PodsPlatform PO = new PodsPlatform();


     //Verifying the new Pod which contains Allocation Ready Status
    @Test
    public void TC07_VerifyStatusOfPod() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.verify_StatusOfPod();

    }
    @Test
    public void TC08_VerifyStatusOfPodAfterNominate() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn().
                click_add_hasher().
                click_ConfirmNomination().
                click_allocationsTab().
                click_Confirm().
                verify_StatusAfterNominate();

    }
    @Test
    public void TC09_VerifyAddingHaSher() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn().
                click_add_hasher().
                click_ConfirmNomination();
    }
    @Test
    public void TC10_VerifyFilterOption() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn().
                click_filter().
                click_apply().
                Verify_TheFilter();

    }
    @Test
    public void TC21_verifyStatusAfterSaveConfiguration() throws InterruptedException{
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_UpcomingPods().
                verify_StatusAfterConfigureThePod();
    }


}
