package Tests;

import Pages.MyPodsPage;
import org.testng.annotations.Test;

public class MyPodsPageTest  extends BaseClass{
    MyPodsPage Mp = new MyPodsPage();

    @Test
    public void TC09_VerifyStatusOfPod(){

        Mp.MyPods().
                VerifyNewPods();
    }

    @Test
    public void TC10_VerifyMessageBeforeNominating(){
        Mp.MyPods().
                PodTab().
                VerifyMessage();
    }
    @Test
    public void TC11_VerifyStatusAfterNominate(){
        Mp.NominateTab().
                NominateButton().
                AddingHaSher().
                ConfirmNominationButton().
                MyPods().
                ConfirmButton().
                VerifyStatusAfterNominating();
    }
    @Test
    public void TC13_VerifyConfidenceLevel() throws InterruptedException {
        Mp.NominateTab().
                NominateButton().
                Filter().
                ResetButton().
                Band().
                ApplyButton().
                AddingHaSher1().
                ConfirmNominationButton().
                MyPods().
                ConfirmButton().
                NominateTab().
                WaitUntilStatusChange().
                MyPodsNomination().
                VerifyingTheConsideredStatus().
                SearchOption().
                ConfidenceLevel().Comments().CheckBox();
    }
    @Test
    public void TC14_VerifyStatusResponded(){
        Mp.MyPods().
                NominateTab().
                VerifyStatusResponded();


    }


}
