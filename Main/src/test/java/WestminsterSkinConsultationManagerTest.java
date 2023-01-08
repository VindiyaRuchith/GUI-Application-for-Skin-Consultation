/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class WestminsterSkinConsultationManagerTest {
    WestminsterSkinConsultationManager consultationManager = new WestminsterSkinConsultationManager();
    
     @Test
    public void testAddNewDoc() throws ParseException {
        // Add a new doctor
  String Name = "John";
  String Surname = "Doe";
  String dateString = "10/12/2021";
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  Date dob = dateFormat.parse(dateString);
  String MobileNumber = "1234567890";
  String Gender = "Male";
  String MedicalLicenseNumber = "123456";
  String Specialization = "Dermatology";
  consultationManager.addDoctor(Name, Surname, dob, MobileNumber, Gender, MedicalLicenseNumber, Specialization);
  
  // Check that the doctor was added
  ArrayList<Doctor> list = consultationManager.getDoctors();
  assertEquals(1, list.size());
  Doctor doctor = list.get(0);
  assertEquals(Name, doctor.getname());
  assertEquals(Surname, doctor.getsurname());
  assertEquals(dob, doctor.getdateofbirth());
  assertEquals(MobileNumber, doctor.getmobilenumber());
  assertEquals(MedicalLicenseNumber, doctor.getmedicallicensenumber());
  assertEquals(Specialization, doctor.getspecialization());
 }
    
    @Test
public void testDeleteDoctor() {
  // Add a new doctor
  String Name = "John";
  String Surname = "Doe";
  String DateOfBirth = "01/01/1970";
  Date dob = new Date(DateOfBirth);
  String MobileNumber = "1234567890";
  String Gender = "Male";
  String MedicalLicenseNumber = "123456";
  String Specialization = "Dermatology";
  consultationManager.addDoctor(Name, Surname, dob, MobileNumber, Gender, MedicalLicenseNumber, Specialization);
  
  // Delete the doctor
  consultationManager.deleteDoctor(MedicalLicenseNumber);
  
  // Check that the doctor was deleted
  ArrayList<Doctor> list = consultationManager.getDoctors();
  assertEquals(0, list.size());
}
    


    @Test
public void testPrintDoctors() {
  // Add a new doctor
  String Name = "John";
  String Surname = "Doe";
  String DateOfBirth = "01/01/1970";
  Date dob = new Date(DateOfBirth);
  String MobileNumber = "1234567890";
  String Gender = "Male";
  String MedicalLicenseNumber = "123456";
  String Specialization = "Dermatology";
  consultationManager.addDoctor(Name, Surname, dob, MobileNumber, Gender, MedicalLicenseNumber, Specialization);
  
  // Print the doctors
  try {
    consultationManager.printDoctors();
  } catch (Exception e) {
    fail("Exception thrown while printing doctors");
  }
}


 
}
