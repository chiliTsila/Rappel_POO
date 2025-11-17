import java.time.LocalDate;

public class Tutor extends Person {
    private String relationshipDescription;

    public Tutor(int id, String lastName, String firstName, LocalDate birthDate, String email, String phone, String relationshipDescription) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.relationshipDescription = relationshipDescription;
    }

    public String getRelationshipDescription() { return relationshipDescription; }
}
