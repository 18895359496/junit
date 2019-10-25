package yingmu.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

/**
 * @author zhouxiang
 * @date 2019/10/25-11:37
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloMock1 {
    @Mock
    private List mockList;
    @Mock
    private Comparable comparable;

    @Test
    public void shorthand() {
        mockList.add(1);
        verify(mockList).add(1);
    }

    @Test
    public void with_arguments() {
        when(comparable.compareTo("hello")).thenReturn(1);
        when(comparable.compareTo("world")).thenReturn(2);
        assertEquals(1, comparable.compareTo("hello"));
        assertEquals(2, comparable.compareTo("world"));

    }

    @Test
    public void with_unspecified_arguments() {
        //匹配任意参数
        when(mockList.get(anyInt())).thenReturn(1);
        // 如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
        when(mockList.contains(argThat(new IsValid()))).thenReturn(true);
        assertEquals(1, mockList.get(1));
        assertEquals(1, mockList.get(999));
        assertTrue(mockList.contains(1));
        // 自动定义参数没通过matchers匹配
        assertFalse(mockList.contains(3));
    }

    private class IsValid extends ArgumentMatcher<List> {
        @Override
        public boolean matches(Object o) {
            return (int) o == 1 || (int) o == 2;
        }
    }

    @Test
    public void argumentMatchersTest(){
        //创建mock对象
        List<String> mock = mock(List.class);

        //argThat(Matches<T> matcher)方法用来应用自定义的规则，可以传入任何实现Matcher接口的实现类。
        when(mock.addAll(argThat(new IsListofTwoElements()))).thenReturn(true);

        mock.addAll(Arrays.asList("one","two","three"));
        //IsListofTwoElements用来匹配size为2的List，因为例子传入List为三个元素，所以此时将失败。
        verify(mock).addAll(argThat(new IsListofTwoElements()));
    }

    class IsListofTwoElements extends ArgumentMatcher<List>
    {
        public boolean matches(Object list)
        {
            return((List)list).size()==2;
        }
    }

}
