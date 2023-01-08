import java.util.Date;

public class Patient extends Person{

    private int id;

    //Patient class calls superclass Person, initializes id with value of id plus one

    public Patient(String Name, String Surname, Date DateOfBirth, String MobileNumber, String Gender, int Id) {
        super(Name, Surname, DateOfBirth, MobileNumber, Gender);
        this.id = Id + 1;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return this.id;
    }
}
