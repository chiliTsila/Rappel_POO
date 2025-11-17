import java.time.LocalDate;

public abstract class Person {
    private int id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String email;
    private String phone;

    public Person(int id, String lastName, String firstName, LocalDate birthDate, String email, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
