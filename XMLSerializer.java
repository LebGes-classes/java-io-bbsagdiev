import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class XMLSerializer {

    public static void serializeToXml(List<Student> students, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(StudentsWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StudentsWrapper wrapper = new StudentsWrapper();
        wrapper.setStudents(students);
        marshaller.marshal(wrapper, new File(filePath));
    }
}
