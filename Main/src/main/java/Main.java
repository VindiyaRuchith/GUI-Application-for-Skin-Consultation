import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean ans = true;
        Scanner scanner = new Scanner(System.in);
        WestminsterSkinConsultationManager skinconsult = new WestminsterSkinConsultationManager();

        //Initially load all the data from the file
        skinconsult.LoadFromFile(WestminsterSkinConsultationManager.list);
        Bookings.LoadFromFile(Bookings.patientList,Bookings.consultationList);

        System.out.println("\n------------------------------------------ Welcome to Westminster Skin Consultation Manager ------------------------------------");

        do {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("|" + "                                                       Console Menu                                                        " + "|");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("| " + "---------------------------------------------Press A to Add new Doctor----------------------------------- " + " |");
            System.out.println("| " + "---------------------------------------------Press D to Delete a Doctor-----------------------------------" + " |");
            System.out.println("| " + "---------------------------------------------Press P to Print the list of Doctors-------------------------" + " |");
            System.out.println("| " + "---------------------------------------------Press S to Save in file--------------------------------------" + " |");
            System.out.println("| " + "---------------------------------------------Press G to Open in User Interface----------------------------" + " |");
            System.out.println("| " + "---------------------------------------------Press Q to Quit the program----------------------------------" + " |");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            System.out.println("Enter your selection:");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A" -> skinconsult.AddNewDoc();
                case "D" -> skinconsult.DeleteDoc();
                case "P" -> skinconsult.PrintListOfDoc();
                case "S" -> skinconsult.SaveInFile();
                case "G" -> EventQueue.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                            UnsupportedLookAndFeelException e) {
                        throw new RuntimeException(e);
                    }
                    new HomePage();
                });
                case "Q" -> ans = false;
            }

        } while (ans);
        System.out.println("\n We hope you had no problems using our services, Thank You :)");
    }
}