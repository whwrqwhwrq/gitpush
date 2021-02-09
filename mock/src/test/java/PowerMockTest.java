import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:wrq
 * @Date:2021/1/28 14:09
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({TestPowerMockController.class,TestUtil.class})
public class PowerMockTest {

    @InjectMocks
    private TestPowerMockController testPowerMockController;

    @Test
    public void testBuild() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        Object build = Whitebox.invokeMethod(testPowerMockController, "build", map);
        Assert.assertEquals(build,"ab");
    }

    @Test
    public void testBuild1() throws Exception {
        Object build = Whitebox.invokeMethod(testPowerMockController, "build", "c");
        Assert.assertEquals(build,"abc");
    }

    @Test
    public void testBuild2() throws Exception {
        Class<? extends TestPowerMockController> testPowerMockControllerClass = testPowerMockController.getClass();
        Method build = testPowerMockControllerClass.getDeclaredMethod("build", Map.class);
        build.setAccessible(true);

        Map<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");

        Object invoke = build.invoke(testPowerMockController, map);

    }

    @Test
    public void testBuild3() {
        MemberModifier.stub(MemberMatcher.method(testPowerMockController.getClass(), "build", Map.class)).toReturn("afds");
        MemberModifier.stub(MemberMatcher.method(TestUtil.class,"sout")).toReturn("sadfads");
        testPowerMockController.build("test");
    }

    @Test
    public void testSout() {
        TestUtil.sout();
    }

    @Test
    public void testTimeReflectAndNormal() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<? extends TestPowerMockController> aClass = testPowerMockController.getClass();
        Method build = aClass.getDeclaredMethod("build", String.class);
        build.setAccessible(true);

        long start = System.currentTimeMillis();
        build.invoke(testPowerMockController, "faker");
        System.out.println(System.currentTimeMillis()-start);

        long start1 = System.currentTimeMillis();
        testPowerMockController.build("faker");
        System.out.println(System.currentTimeMillis()-start1);

    }

    @Test
    public void testJSONString() {
        String json = "{\n" +
                "\n" +
                "\"employees\": [\n" +
                "\n" +
                "{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },\n" +
                "\n" +
                "{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },\n" +
                "\n" +
                "{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
        String abc = JSON.toJSONString(json);
        System.out.println(abc);
    }
}
