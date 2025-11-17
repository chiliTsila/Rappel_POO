import java.time.Instant;

public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant when;
    private double coefficient;

    public Exam(int id, String title, Course course, Instant when, double coefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.when = when;
        this.coefficient = coefficient;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Course getCourse() { return course; }
    public Instant getWhen() { return when; }
    public double getCoefficient() { return coefficient; }
}
