package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    StudentHardCodeDatasource datasource = new  StudentHardCodeDatasource();
    @Test
    @DisplayName("ทดสอบ ReadData")
    void testReadData() {
        StudentList studentList = datasource.readData();
        assertEquals(4, studentList.getStudents().size() );

        Student student1 = studentList.findStudentById("6710400001");
        assertEquals("First", student1.getName());
        Student student2 = studentList.findStudentById("6710400002");
        assertEquals("Second", student2.getName());
        Student student3 = studentList.findStudentById("6710400003");
        assertEquals("Third", student3.getName());
        Student student4 = studentList.findStudentById("6710400004");
        assertEquals("Fourth", student4.getName());
    }
}