// Each rule checks one condition and returns a reason if it fails
public interface EligibilityRule {
    // returns null if the student passes, or a reason string if they fail
    String check(StudentProfile student);
}
