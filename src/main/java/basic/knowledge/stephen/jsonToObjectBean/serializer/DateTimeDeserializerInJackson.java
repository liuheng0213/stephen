package basic.knowledge.stephen.jsonToObjectBean.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;


public class DateTimeDeserializerInJackson extends JsonDeserializer<DateTime> {
    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try
        {
            if(jsonParser!=null&& StringUtils.isNotEmpty(jsonParser.getText())){
                String json = jsonParser.getText();
                DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DateTimeSerializerInGson.DATETIME_PATTERN);
                DateTime dateTime1 = dateTimeFormatter.parseDateTime(json);
                return dateTime1;
            }else {
                return null;
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
