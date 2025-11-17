import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SchoolService {
    private final List<Note> notes = new ArrayList<>();

    public void addNote(Note note) { notes.add(note); }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        for (Note n : notes) {
            if (n.getExam().getId() == exam.getId() && n.getStudent().getId() == student.getId()) {
                return n.getValueAt(t);
            }
        }
        return Double.NaN;
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        double sum = 0;
        double denom = 0;
        for (Note n : notes) {
            if (n.getStudent().getId() == student.getId() && n.getExam().getCourse().getId() == course.getId()) {
                double val = n.getValueAt(t);
                if (!Double.isNaN(val)) {
                    double coeff = n.getExam().getCoefficient();
                    sum += val * coeff;
                    denom += coeff;
                }
            }
        }
        return denom == 0 ? Double.NaN : sum / denom;
    }
}
