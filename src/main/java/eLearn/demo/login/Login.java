package eLearn.demo.login;
public class Login {
    private String emailPhone;
    private String password;

    public Login() {
    }

    public Login(String emailPhone, String password) {
        this.emailPhone = emailPhone;
        this.password = password;
    }

    public String getEmailPhone() {
        return emailPhone;
    }

    public void setEmailPhone(String emailPhone) {
        this.emailPhone = emailPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "emailPhone='" + emailPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
