package by.vabramov.spring.core.course.v2;

public class ClientV2 {
    private String id;
    private String fullName;

    public ClientV2() {
    }

    public ClientV2(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
