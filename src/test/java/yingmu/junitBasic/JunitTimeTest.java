package yingmu.junitBasic;

import org.junit.Test;

/**
 * @author zhouxiang
 * @date 2019/10/24-14:48
 */
public class JunitTimeTest {

    @Test(expected = NullPointerException.class)
    public void testTimeout() {
        Object o = null;
        o.toString();
    }
}
