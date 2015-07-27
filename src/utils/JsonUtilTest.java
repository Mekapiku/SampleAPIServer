package utils;

import beans.TempSensorData;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mitsuyasu on 2015/07/27.
 */
public class JsonUtilTest extends TestCase {

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static String jsonStab = "{\"temp\":10.0,\"date\":\"2015-04-03 11:00:00\"}";

    @Before
    public void testInit() {
    }

    @Test
    public void testParseJson() throws Exception {
        TempSensorData data = JsonUtil.fromJson(jsonStab, TempSensorData.class);
        {
            System.out.println("========== Test1 Date ==========");
            Date date = new SimpleDateFormat(DATE_FORMAT).parse("2015-04-03 11:00:00");
            assertEquals(data.getDate(), date);
            System.out.println("OK");
        }
        {
            System.out.println("========== Test1 Temp ==========");
            assertEquals(data.getTemp(), 10.0f);
            System.out.println("OK");
        }
    }

    @Test
    public void testToJson() throws Exception {
        TempSensorData data = new TempSensorData();
        {
            data.setDate(new SimpleDateFormat(DATE_FORMAT).parse("2015-04-03 11:00:00"));
            data.setTemp(10.0f);
        }
        System.out.println("========== Test2 ==========");
        assertEquals(JsonUtil.toJson(data), jsonStab);
        System.out.println("OK");

        {
            data.setDate(new Date());
            data.setTemp((float) Math.random() * 10.0f);
        }
        System.out.println("========== Test3 ==========");
        assertNotNull(JsonUtil.toJson(data));
        System.out.println("OK");
    }
}