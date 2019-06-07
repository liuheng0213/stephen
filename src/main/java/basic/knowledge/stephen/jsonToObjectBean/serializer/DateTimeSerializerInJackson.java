package basic.knowledge.stephen.jsonToObjectBean.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class DateTimeSerializerInJackson extends JsonSerializer<DateTime>{

    public static String DATETIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DateTimeSerializerInJackson.DATETIME_PATTERN);
    @Override
    public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(dateTime.toString(DateTimeSerializerInJackson.DATETIME_PATTERN));
    }
}
