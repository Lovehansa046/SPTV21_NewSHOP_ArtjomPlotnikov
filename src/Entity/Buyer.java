package Entity;

public class Buyer {

    private String firstname;
    private String lastname;
    private String phone;

    private int Cash;

    public Buyer(){
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCash() {
        return Cash;
    }

    public void setCash(int cash) {
        Cash = cash;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", Cash=" + Cash +
                '}';
    }
}
