import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Note {
    private Student student; 
    private Exam exam;       
    private List<GradeChange> history = new ArrayList<>();

    public Note(Student student, Exam exam, double initialValue, Instant at, String reason) {
        this.student = student;
        this.exam = exam;
        this.history.add(new GradeChange(initialValue, at, reason));
    }

    public Student getStudent() { return student; }
    public Exam getExam() { return exam; }

    public void addChange(double value, Instant at, String reason) {
        history.add(new GradeChange(value, at, reason));
    }

    public List<GradeChange> getHistory() { return Collections.unmodifiableList(history); }

    public double getValueAt(Instant t) {
        GradeChange last = null;
        for (GradeChange gc : history) {
            if (!gc.getAt().isAfter(t)) {
                if (last == null || gc.getAt().isAfter(last.getAt())) {
                    last = gc;
                }
            }
        }
        if (last == null) return Double.NaN;
        return last.getValue();
    }
}
