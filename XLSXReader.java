import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLSXReader {

    public static List<Student> readStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Student student = new Student();
                student.setId((int) row.getCell(0).getNumericCellValue());
                student.setName(row.getCell(1).getStringCellValue());
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            throw e;
        } catch (IOException e) {
            System.err.println("I/O error occurred while reading the file: " + filePath);
            throw e;
        }
        return students;
    }
}
