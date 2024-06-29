package runner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunnerTest {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:features")
                .outputCucumberJson(true)
                .parallel(2);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}
