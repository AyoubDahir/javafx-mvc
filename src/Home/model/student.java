package Home.model;

public class student
{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String batchcode;
    private String gender;
    private String enrollnum;
    private String dob;


    public student()
    {

    }
    public student(String name, String address, String phone, String email, String batchcode, String gender, String enrollnum, String dob) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.batchcode = batchcode;
        this.gender = gender;
        this.enrollnum = enrollnum;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatchcode() {
        return batchcode;
    }

    public void setBatchcode(String batchcode) {
        this.batchcode = batchcode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnrollnum() {
        return enrollnum;
    }

    public void setEnrollnum(String enrollnum) {
        this.enrollnum = enrollnum;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
