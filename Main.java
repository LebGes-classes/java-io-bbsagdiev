import java.io.IOException;
import javax.xml.bind.JAXBException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Убедитесь, что путь к файлу правильный
            String xlsxFilePath = "students.xlsx";
            List<Student> students = XLSXReader.readStudents(xlsxFilePath);

            // Сериализация данных в JSON
            JSONSerializer.serializeToJson(students, "students.json");

            // Десериализация данных из JSON
            List<Student> deserializedStudentsFromJson = JSONDeserializer.deserializeFromJson("students.json");

            // Сериализация данных в XML
            XMLSerializer.serializeToXml(students, "students.xml");

            // Десериализация данных из XML
            List<Student> deserializedStudentsFromXml = XMLDeserializer.deserializeFromXml("students.xml");

            // Вывод десериализованных данных
            System.out.println("Deserialized from JSON: " + deserializedStudentsFromJson);
            System.out.println("Deserialized from XML: " + deserializedStudentsFromXml);

        } catch (IOException | JAXBException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
