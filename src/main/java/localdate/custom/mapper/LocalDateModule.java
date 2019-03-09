package localdate.custom.mapper;

import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import localdate.custom.mapper.serializer.LocalDateSerializer;
import localdate.custom.mapper.serializer.LocalDateTimeSerializer;
import localdate.custom.mapper.deserializer.LocalDateDeserializer;
import localdate.custom.mapper.deserializer.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class LocalDateModule extends SimpleModule {

    private static final String NAME = "LocalDateModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil() {
    };

    public LocalDateModule() {
        super(NAME, VERSION_UTIL.version());
        addSerializer(LocalDate.class, new LocalDateSerializer());
        addDeserializer(LocalDate.class, new LocalDateDeserializer());
        addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
    }

}