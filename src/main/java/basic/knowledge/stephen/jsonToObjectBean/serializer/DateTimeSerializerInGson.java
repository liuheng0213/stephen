package basic.knowledge.stephen.jsonToObjectBean.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Type;

public class DateTimeSerializerInGson implements JsonSerializer<DateTime>, com.google.gson.JsonDeserializer<DateTime> {
    public static String DATETIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DateTimeSerializerInGson.DATETIME_PATTERN);

    @Override
    public JsonElement serialize(DateTime dateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(dateTime.toString(DateTimeSerializerInGson.DATETIME_PATTERN));
    }


    @Override
    public DateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        /**
         * 若读取到的字符串 为 "" 或者  "null"
         * 则返回 null
         */
        String res = jsonElement.getAsString();
        if (res.length() < 5) {
            return null;
        }
        try {
            DateTime dateTime = dateTimeFormatter.parseDateTime(res);
            return dateTime;
        } catch (JsonParseException e) {
            throw new JsonParseException("日期格式不正确 应该为:" + DateTimeSerializerInGson.DATETIME_PATTERN);
        }
    }
}
