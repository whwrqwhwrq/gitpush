package wrq.mybatis.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:wrq
 * @Date:2020/11/2 17:47
 */
public class JsonDateFormatUtil {

    private static  ObjectMapper objectMapper;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getFormattedDateJson(Date date) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(simpleDateFormat);

        return objectMapper.writeValueAsString(date);

    }
    public static String getFormattedDateJson(Date date,String format) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        objectMapper.setDateFormat(simpleDateFormat);

        return objectMapper.writeValueAsString(date);

    }
}
