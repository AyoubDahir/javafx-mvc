package Home.model;

public class Teacher {
    private String name;
    private String gender;
    private String address;
    private String subject;

    public Teacher(){}

    public Teacher(String name, String gender, String address, String subject) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.subject = subject;
    }

    public Teacher(String name, String address, String gender) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
