import java.util.Date;

public class Doctor extends Person implements Comparable<Doctor> {
    private String medicallicensenumber;
    private String specialization;

    //Constructor for Doctor class to specify values for the instance variables

    public Doctor(String Name, String Surname, Date DateOfBirth, String MobileNumber, String Gender, String MedicalLicenseNumber, String Specialization) {
        super(Name, Surname, DateOfBirth, MobileNumber, Gender);
        this.medicallicensenumber = MedicalLicenseNumber;
        this.specialization = Specialization;
    }

    public Doctor(){}

    public String getmedicallicensenumber() {
        return medicallicensenumber;
    }

    public String getspecialization() {
        return specialization;
    }

    public void setspecialization(String specialization) {
        this.specialization = specialization;
    }

    //The compareTo method to compare the Doctor objects based on surname

    @Override
    public int compareTo(Doctor o) {
        return this.getsurname().compareToIgnoreCase(o.getsurname());
    }
}
