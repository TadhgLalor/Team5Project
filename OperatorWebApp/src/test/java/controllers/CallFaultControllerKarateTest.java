package controllers;
import com.ericsson.owa.OperatorWebAppApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OperatorWebAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CallFaultControllerKarateTest {

    @Karate.Test
    Karate testCallFaultController() {
        return Karate.run("call_fault_controller").relativeTo(getClass());
    }

}
