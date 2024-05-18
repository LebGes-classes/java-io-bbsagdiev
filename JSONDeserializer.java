public class JSONDeserializer import com.fasterxml.jackson.databind.ObjectMapper;

        import java.io.File;
        import java.io.IOException;
        import java.util.List;

public class JSONDeserializer {

    public static List<Student> deserializeFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
    }
}
{
}
