import java.util.HashSet;
import java.util.Set;

public class Promotion {
    private Set<String> groups = new HashSet<>();

    public Promotion() {}

    public void addGroup(String g) { groups.add(g); }
    public Set<String> getGroups() { return Set.copyOf(groups); }
}
