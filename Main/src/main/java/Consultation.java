import java.util.Date;

public class Consultation extends Doctor{
    private final String timeslot;
    private final String cost;
    private String notes;
    private final Date date;
    private final String doctorname;

    public Consultation(String Name, String Specialization, Date dAte, String TimeSlot, String Notes, String Cost){
        this.doctorname = Name;
        super.setspecialization(Specialization);
        this.date = dAte;
        this.timeslot = TimeSlot;
        this.notes = Notes;
        this.cost = Cost;

    }
    public String gettimeslot() {
        return timeslot;
    }

    public String getcost() {
        return cost;
    }

    public String getnotes() {
        return notes;
    }


    public void setnotes(String notes) {
        this.notes = notes;
    }


    public String getDoctorName(){
        return doctorname;
    }
    public Date getdate(){
        return date;
    }
}
