import java.time.Instant;

public class GradeChange {
    private double value;
    private Instant at;
    private String reason;

    public GradeChange(double value, Instant at, String reason) {
        this.value = value;
        this.at = at;
        this.reason = reason;
    }

    public double getValue() { return value; }
    public Instant getAt() { return at; }
    public String getReason() { return reason; }
}
