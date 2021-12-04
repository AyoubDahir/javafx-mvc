package Home.model;

public class subject
{
    private String subjectname;
    private  String code;

    public subject(){}

    public subject(String subjectname, String code) {
        this.subjectname = subjectname;
        this.code = code;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
