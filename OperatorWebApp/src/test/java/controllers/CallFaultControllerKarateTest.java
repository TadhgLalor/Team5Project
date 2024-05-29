package controllers;
import com.intuit.karate.junit5.Karate;


public class CallFaultControllerKarateTest {

    @Karate.Test
    Karate testCallFaultController() {
        return Karate.run("call_fault_controller").relativeTo(getClass());
    }

}
