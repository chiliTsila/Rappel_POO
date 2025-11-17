import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SchoolServiceTest {

    @Test
    public void examGradeRespectsHistoryAtInstant() {
        Tutor tutor = new Tutor(1, "Dupont", "Paul", LocalDate.of(1970,1,1), "t@example.com", "0101010101", "father");
        Student s = new Student(10, "Martin", "Alice", LocalDate.of(2000,5,5), "a@example.com", "0202020202", "G1", tutor);
        Teacher tchr = new Teacher(2, "Leprof", "Jean", LocalDate.of(1980,2,2), "p@example.com", "0303030303", "back-end");
        Course course = new Course(100, "PROG2", 6, tchr);
        Instant t0 = Instant.parse("2025-06-01T10:00:00Z");
        Instant t1 = Instant.parse("2025-06-02T10:00:00Z");

        Exam exam = new Exam(200, "Midterm", course, t0, 2.0);
        Note note = new Note(s, exam, 12.0, t0, "initial");
        note.addChange(14.0, t1, "regrade");

        SchoolService svc = new SchoolService();
        svc.addNote(note);

    assertEquals(12.0, svc.getExamGrade(exam, s, t0));
    assertEquals(14.0, svc.getExamGrade(exam, s, t1.plusSeconds(1)));
    }

    @Test
    public void courseGradeIsWeightedAverage() {
        Tutor tutor = new Tutor(1, "Dupont", "Paul", LocalDate.of(1970,1,1), "t@example.com", "0101010101", "mother");
        Student s = new Student(11, "Lopez", "Eva", LocalDate.of(2001,3,3), "e@example.com", "0404040404", "G2", tutor);
        Teacher tchr = new Teacher(3, "Smith", "Ana", LocalDate.of(1975,4,4), "s@example.com", "0505050505", "front-end");
        Course course = new Course(101, "PROG2", 6, tchr);

        Instant t0 = Instant.parse("2025-06-01T09:00:00Z");
        Exam e1 = new Exam(201, "Exam1", course, t0, 2.0);
        Exam e2 = new Exam(202, "Exam2", course, t0, 3.0);

        Note n1 = new Note(s, e1, 10.0, t0, "initial");
        Note n2 = new Note(s, e2, 15.0, t0, "initial");

        SchoolService svc = new SchoolService();
        svc.addNote(n1);
        svc.addNote(n2);

    double grade = svc.getCourseGrade(course, s, t0.plusSeconds(1));
    assertEquals(13.0, grade, 1e-9);
    }
}
