import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLDeserializer {

    public static List<Student> deserializeFromXml(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(StudentsWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StudentsWrapper wrapper = (StudentsWrapper) unmarshaller.unmarshal(new File(filePath));
        return wrapper.getStudents();
    }
}
