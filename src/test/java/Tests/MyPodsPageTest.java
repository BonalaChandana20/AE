package Tests;

import Pages.Allocate;
import Pages.Login;
import Pages.MyPods;
import Pages.PodsPlatform;
import org.testng.annotations.Test;

public class MyPodsPageTest  extends BaseClass{
    MyPods ProductOwner = new MyPods();
    Login login = new Login();
    PodsPlatform PO = new PodsPlatform();
    Allocate AllocationOwner = new Allocate();


    @Test
    public void TC09_VerifyStatusOfPod() throws InterruptedException{
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        ProductOwner.click_MyPods().
                verify_NewPods();
    }

    @Test
    public void TC10_VerifyMessageBeforeNominating() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        ProductOwner.click_MyPods().
                click_pod(PO.pod_id).
                Verify_Message();
    }
    @Test
    public void TC11_VerifyStatusAfterNominate() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_add_hasher()
                .click_ConfirmNomination();
        ProductOwner
                .click_MyPods()
                .click_ConfirmButton()
                .Verify_StatusAfterNominating();

    }
    @Test
    public void TC13_VerifyConfidenceLevel() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_Band()
                .click_apply()
                .click_add_hasher().
                click_ConfirmNomination();
        ProductOwner.click_MyPods().
                click_ConfirmButton().
                click_pod(PO.pod_id).
                wait_for_consideration().
                click_MyPodsNomination().
                Verifying_TheConsideredStatus().
                click_SearchOption().
                provide_ConfidenceLevel()
                .Comments().select_hasher();
    }
    @Test
    public void TC14_VerifyStatusResponded() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        ProductOwner.click_MyPods().
                click_pod(PO.pod_id).
                Verify_StatusResponded();


    }


}
