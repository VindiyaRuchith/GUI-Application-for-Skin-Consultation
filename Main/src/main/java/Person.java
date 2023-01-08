import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private String surname;
    private Date dateofbirth;
    private String mobilenumber;
    private String gender;

    public void setname(String name) {
        this.name = name;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    public void setdateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setmobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    Person(){ }

    //Constructor for Person class to specify values for the instance variables

    Person(String Name,String Surname, Date DateOfBirth, String MobileNumber, String Gender){
        this.name = Name;
        this.surname = Surname;
        this.dateofbirth = DateOfBirth;
        this.mobilenumber = MobileNumber;
        this.gender = Gender;
    }

    public String getname() {
        return name;
    }

    public String getsurname() {
        return surname;
    }

    public Date getdateofbirth() {
        return dateofbirth;
    }

    public String getmobilenumber() {
        return mobilenumber;
    }

    public String getgender() {
        return gender;
    }
}