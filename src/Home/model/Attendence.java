package Home.model;

public class Attendence {
    private String date;
    private String studentid;
    private String subjectid;
    private String status;

   public Attendence(){}

    public Attendence(String date, String studentid, String subjectid, String status) {
        this.date = date;
        this.studentid = studentid;
        this.subjectid = subjectid;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
