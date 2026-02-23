// Interface so we can swap out the storage later without touching the service
public interface StudentStore {
    void save(StudentRecord r);
    int count();
}
