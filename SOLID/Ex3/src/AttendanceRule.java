public class AttendanceRule implements EligibilityRule {
    public String check(StudentProfile student) {
        if (student.attendancePct < 75) {
            return "attendance below 75";
        }
        return null;
    }
}
