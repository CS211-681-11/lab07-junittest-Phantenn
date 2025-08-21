package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;

    @BeforeEach
    void init() {
        student = new Student("6xxxxxxxxx", "StudentTest");
    }
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 41.01 คะแนน")
    void testAddScore(){
        student.addScore(41.01);
        assertEquals(41.01, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        student.addScore(85);
        assertEquals("A", student.grade());
    }

    @Test
    @DisplayName("ืทดสอบการเปลี่ยนชื่อเป็น Ten")
    void testChangeName(){
        student.changeName("Ten");
        assertEquals("Ten", student.getName());
    }

    @Test
    @DisplayName("ทดสอบการเทียบ id")
    void testIsId() {
        assertEquals(true, student.isId("6xxxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการมีอยู่ของ name")
    void testIsNameContains() {
        assertEquals(true, student.isNameContains("StudentTest"));
    }
}