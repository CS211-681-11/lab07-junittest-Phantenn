package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;

    @BeforeEach
    void init() {
        studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "StudentTest");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียน")
    void testAddNewStudent() {
        studentList.addNewStudent("6xxxxxxx1", "StudentTest1");
        studentList.addNewStudent("6xxxxxxx2", "StudentTest2", 80.1);
        assertEquals(2, studentList.getStudents().size());
        assertEquals("6xxxxxxx1", studentList.getStudents().get(1).getId());
        assertEquals("6xxxxxxx2", studentList.getStudents().get(2).getId());
        assertEquals("StudentTest1", studentList.getStudents().get(1).getName());
        assertEquals("StudentTest2", studentList.getStudents().get(2).getName());
        assertEquals("A", studentList.getStudents().get(2).getGrade());
        assertEquals(80.1, studentList.getStudents().get(2).getScore());
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนด้วย id")
    void testFindStudentById() {
        Student x = studentList.findStudentById("6xxxxxxxx");
        assertEquals(studentList.getStudents().getFirst(), x);
    }

    @Test
    @DisplayName("ทดสอบการกรองชื่อนักเรียน")
    void testFilterByName() {
        studentList.addNewStudent("6xxxxxxx1", "Johnny");
        studentList.addNewStudent("6xxxxxxx2", "John");
        assertEquals(2, studentList.filterByName("John").getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนน")
    void testGiveScoreToId() {
        studentList.giveScoreToId("6xxxxxxxx", 80.0);
        assertEquals(80.0, studentList.getStudents().getFirst().getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดด้วย id")
    void testViewGradeOfid() {
        studentList.giveScoreToId("6xxxxxxxx", 80.0);
        assertEquals("A", studentList.viewGradeOfId("6xxxxxxxx"));
    }
}