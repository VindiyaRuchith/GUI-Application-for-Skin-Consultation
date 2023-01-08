import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    //Creating a new arraylist with an initial capacity of 10
    public static ArrayList<Doctor> list = new ArrayList<>(10);
    // declaration for the field dateFormat
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    // Code for the method AddNewDoc to add doctors into the list.maximum of 10 doctors

    @Override
    public void AddNewDoc() {
        String choice = "";
        do {
            try{
                // assigning the size of the list to the variable count
                int count = list.size();

                //Checking if list has 10 doctors
                if (!(count == 10)){
                    System.out.println("######################################################################################################################");
                    System.out.println("----------------------------------------------------Add New Doctor----------------------------------------------------");
                    System.out.println("######################################################################################################################");
                    System.out.println("Enter the Name of the Doctor:");
                    String docName = "Dr. " + scanner.next();

                    System.out.println("Enter the Surname of the Doctor:");
                    String surname = scanner.next();

                    System.out.println("Enter the Mobile Number of the Doctor:");
                    String mob = scanner.next();

                    System.out.println("Select the Gender:");
                    System.out.println("1. Male\n2. Female");
                    int select = scanner.nextInt();
                    String gen;
                    if (select == 1) {
                        gen = "Male";
                    } else if (select == 2) {
                        gen = "Female";
                    }else {
                        System.out.println("Invalid Selection");
                        break;
                    }

                    System.out.println("Enter Doctor's Date of Birth format ---> (dd/MM/yyyy):");
                    String doctorDob = scanner.next();
                    Date dob = dateFormat.parse(doctorDob);

                    System.out.println("Enter Medical License Number of the Doctor:");
                    String medNumber = scanner.next();

                    System.out.println("Select the specialization from the below:");
                    System.out.println("1. Cosmetic dermatology\n2. Medical dermatology,\n3. Paediatric dermatology\n4. Other");
                    int num = scanner.nextInt();
                    String specialization = "";
                    if (num == 1){
                        specialization = "Cosmetic dermatology";
                    } else if (num == 2) {
                        specialization = "Medical dermatology";
                    } else if (num == 3) {
                        specialization = "Paediatric dermatology";
                    } else if (num == 4) {
                        System.out.println("Enter the specialization:");
                        specialization = scanner.next();
                    }else {
                        System.out.println("You entered the wrong selection");
                    }

                    Doctor doc = new Doctor(docName, surname, dob, mob, gen, medNumber, specialization);
                    list.add(doc);
                    System.out.println("Doctor Added Successfully!");
                    System.out.println("\nYou can add " + (10 - (++count)) + " more doctors to the center");

                    System.out.println("Do you want add another Doctor?(Y/N):");
                    choice = scanner.next();
                }
                else {
                    System.out.println("Can't add Doctors, Your Center is full!");
                    break;
                }
            }
            catch (ParseException e){
                System.out.println("Format of entered value is invalid!");
            }
            catch (Exception a){
                System.out.println("Can't add Doctor to the center at the moment, Please try again later!");
            }
        }
        while (choice.equalsIgnoreCase("Y"));
        System.out.println("You will be taken back to the main menu shortly.......");
    }

    //Code for method DeleteDoc to delete doctors from the list
    @Override
    public void DeleteDoc() {
        try {
            System.out.println("######################################################################################################################");
            System.out.println("------------------------------------------------Delete a Doctor-------------------------------------------------------");
            System.out.println("######################################################################################################################");

            System.out.println("Enter the Medical License Number of the Doctor :");
            String medicalLicence = scanner.next();

            //Checks if list is empty, if it is not goes through every entry
            if (!(list.isEmpty())) {
                for (Doctor doctor : list) {
                    //comparing medical license number until correct one found
                    if (medicalLicence.equals(doctor.getmedicallicensenumber())) {
                        System.out.println("Do you want to delete doctor " + doctor.getname() + " from the center?(Y/N)");
                        String ans = scanner.next();

                        if (ans.equalsIgnoreCase("y")) {
                            list.remove(doctor);
                            System.out.println("Doctor removed from list successfully!");
                        } else {
                            System.out.println("You will be taken back to the main menu shortly.......");
                        }
                        break;
                    }
                }
            } else {
                System.out.println("Doctor not found!");
            }
        } catch (Exception e) {
            System.out.println("Doctor can't delete from the center, Something went wrong!");
        }

    }

    // Code for method PrintListofDoc which prints the list of the doctors entered in the center
    @Override
    public void PrintListOfDoc() {
        try{
            System.out.println("########################################################################################################################");
            System.out.println("-------------------------------------------------------List of Doctors--------------------------------------------------");
            System.out.println("######################################################################################################################\n");
            //Using printf to print a formatted string with placeholders
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %s\n", "Name", "Surname", "Gender", "Date of birth", "Mobile number", "Medical License Number", "Specialization\n");

            if (list.isEmpty()){
                System.out.println("\n");
                System.out.println("-------------------------List Is Empty !, Add Doctors-----------------------------");
                System.out.println("\n");
            }
            else {
                //creating new arraylist to sort
                ArrayList<Doctor> sortedList = new ArrayList<>(list.size());
                //add main array list object to new arraylist
                sortedList.addAll(list);
                //sort new array list using comparable class
                Collections.sort(sortedList);
                for (Doctor doc:
                        sortedList) {
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %s\n", doc.getname(), doc.getsurname(), doc.getgender(), dateFormat.format(doc.getdateofbirth()), doc.getmobilenumber(), doc.getmedicallicensenumber(), doc.getspecialization());
                }
            }
            System.out.println("\n");
        }
        catch (Exception e){
            System.out.println("Error !, Unable to print the List of Doctors at the moment");
        }
    }

    //Code for method SaveInFile to save the entered list of doctors in text file
    @Override
    public void SaveInFile() {
        try {
            //writing the data into the file
            FileOutputStream fo = new FileOutputStream("doctorlist.txt");
            //writing the objects into the file
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Doctor doctor: list) {
                oos.writeObject(doctor);
            }
            fo.close();
            oos.close();
            System.out.println("Saved to File!");

        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    //Code for method LoadFromFile to load the list of doctors saved in text file into the console
    //Reads list of objects from the file and adds them to the ArrayList
    @Override
    public void LoadFromFile(ArrayList<Doctor> list){
        try{
            //reading the data from the text file
            FileInputStream fis = new FileInputStream("doctorlist.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try{
                    Doctor doctor = (Doctor) ois.readObject();
                    list.add(doctor);
                }
                catch (Exception e){
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("File not found!");
        }
    }
    
    public ArrayList<Doctor> getDoctors() {
        return list;
    }
    
    public void addDoctor(String Name, String Surname, Date DateOfBirth, String MobileNumber, String Gender, String MedicalLicenseNumber, String Specialization) {
        // Create a new Doctor object with the given information
        Doctor doctor = new Doctor(Name, Surname, DateOfBirth, MobileNumber, Gender, MedicalLicenseNumber, Specialization);
  
            // Add the doctor to the list of doctors
            list.add(doctor);
    }
    
    public void deleteDoctor(String MedicalLicenseNumber) {
    for (int i = 0; i < list.size(); i++) {
        Doctor doctor = list.get(i);
        if (doctor.getmedicallicensenumber().equals(MedicalLicenseNumber)) {
            list.remove(i);
            System.out.println("Doctor " + doctor.getname() + " " + doctor.getsurname() + " with medical licence number " + MedicalLicenseNumber + " has been deleted.");
            System.out.println("Total number of doctors in the centre: " + list.size());
            return;
        }
    }
}
}