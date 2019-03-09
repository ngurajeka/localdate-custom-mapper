# LocalDate Custom Mapper

## How to use

Create a configuration class on your spring boot application and register the LocalDateModule

```java
@Configuration
public class SerializerConfig {

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return new CustomObjectMapper();
    }

    @Bean
    public SerializationConfig serializationConfig() {
        return jacksonObjectMapper().getSerializationConfig();
    }

    static class CustomObjectMapper extends ObjectMapper {

        CustomObjectMapper() {
            registerModule(new LocalDateModule());
        }

    }

}
```

Now, we put the custom serializer in our form handler

```
@JsonDeserialize(using = LocalDateDeserializer.class)
@JsonSerialize(using = LocalDateSerializer.class)
@DateTimeFormat(pattern = LocalDateConstant.DATE_FORMAT)
private LocalDate transactionDate;
```

## What's next

[] Proper Documentation