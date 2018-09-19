package TestSuite;


import FilterAssert.FilterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

        {FilterTest.class
        }
)
public class TestSuite {
}
