package yingmu.junitBasic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import yingmu.junitBasic.AsserttionsTest;
import yingmu.junitBasic.EmpBusinessLogicTest;

/**
 * @author zhouxiang
 * @date 2019/10/24-14:40
 */
@RunWith(Suite.class )
@Suite.SuiteClasses({
        AsserttionsTest.class,
        EmpBusinessLogicTest.class
})

public class SuiteTest {

}
