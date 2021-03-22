package cn.hfanmo.lzspa.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author : KasonZzz
 * @className : LongJsonSerializer
 * @description : Long类型字段序列化时转为字符串，避免js丢失精度
 * @date : 2020/7/21 14:38
 */
public class LongJsonSerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(
            Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        String text = (value == null ? null : String.valueOf(value));
        if (text != null) {
            jsonGenerator.writeString(text);
        }
    }
}
