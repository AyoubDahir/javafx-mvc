package Home.model;

public class user
{
    private String username;
    private String password;

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public user()
    {

    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
