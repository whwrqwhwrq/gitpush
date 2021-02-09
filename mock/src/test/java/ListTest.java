import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {
    //创建mock对象
    @Mock
    List mockList;
    @Mock
    ArrayList<String> stringArrayList;
    @Mock
    List<String> strings;
    @Test
    public void test() {
//        List mockList = Mockito.mock(List.class);
        Assert.assertTrue(mockList instanceof List);
        Assert.assertTrue(stringArrayList instanceof List);
        Assert.assertTrue(stringArrayList instanceof ArrayList);
        //配置 Mock 对象
        //当我们有了一个 Mock 对象后, 我们可以定制它的具体的行为
        when(stringArrayList.add("javajava")).thenReturn(true);
        when(stringArrayList.size()).thenReturn(1);
        Assert.assertTrue(stringArrayList.add("javajava"));
        System.out.println(stringArrayList.add("javajava"));
        Assert.assertEquals(stringArrayList.size(), 1);
        System.out.println(stringArrayList.size());

        Assert.assertFalse(stringArrayList.add("php"));
        System.out.println(stringArrayList.add("php"));

    }

    @Test
    /**
     * 校验 Mock 对象的方法调用
     */
    public void testVerify() {
        //先向刚定义的实例变量mockList中添加元素
        mockList.add("txt");
        mockList.add("exe");
        mockList.add("zip");
        mockList.add("zip");
        mockList.add("zip");
        for (int i = 0; i < 99; i++) {
            mockList.add("dll");
        }
        //定制mock对象
        when(mockList.size()).thenReturn(222);
        Assert.assertTrue(mockList.size() == 222);

        /*
        校验mockList调用 方法的 次数 是否符合条件
         */
        //首先校验是否调用了一次add("txt")方法
        verify(mockList, times(1)).add("txt");
        //校验是否至少调用了一次add("exe")方法
        verify(mockList, atLeastOnce()).add("exe");
        //校验是否调用了三次add("zip")方法
        verify(mockList, times(3)).add("zip");
        //校验是否调用了九十九次add("dll")方法
        verify(mockList, times(99)).add("dll");
        //校验是否从来没有调用过get方法
        verify(mockList,never()).get(100);
        //   验证会失败     verify(mockList,atLeastOnce()).get(100);
    }

    @Test
    /*
    测试spy
     */
    public void testSpy() {
        LinkedList<Object> ll = new LinkedList<>();
        LinkedList<Object> spyLl = spy(ll);
        // 对 spyLl.size() 进行定制.
        when(spyLl.size()).thenReturn(1000);

        spyLl.add(122L);
        spyLl.add(123L);
        //由于并没有对spyLl定制get(1)、get(0)方法，所以以下调用调用的是真实的方法
        Assert.assertEquals(spyLl.get(0),122L);
        Assert.assertEquals(spyLl.get(1),123L);

        Assert.assertEquals(spyLl.size(),1000);

    }

    @Test
    /**
     * 参数捕获
     *
     * Mockito 允准我们捕获一个 Mock 对象的方法调用所传递的参数, 例如:
     */
    public void testCaptor() {
        List<String> stringList = Arrays.asList("飞", "翔", "的", "雄", "鹰");
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        strings.addAll(stringList);
        /*
        通过 verify(mockedList).addAll(argument.capture()) 语句
        来获取 mockedList.addAll 方法所传递的实参 list.
         */
        verify(strings).addAll(argumentCaptor.capture());

        Assert.assertEquals(5,argumentCaptor.getValue().size());
        Assert.assertEquals(stringList,argumentCaptor.getValue());
    }
}
