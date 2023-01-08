import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Bookings extends JFrame {
    public static final ArrayList<Patient> patientList = new ArrayList<>();
    public static final ArrayList<Consultation> consultationList = new ArrayList<>();
    private JButton HomepageBtn;
    private final JTextField textFieldForFirstName, textFieldForSurname, textFieldForMobileNumber;
    private final JLabel labelFieldForDOB, labelForconsultDate;
    private final JTextArea textAreaForNotes;
    private final JRadioButton male;
    private String gender, dob, selectedDate, nameOfTheSelectedDoctor;
    private Date date, selecteddDate;
    private JComboBox comboForSpecialization, comboBoxForDocName, jComboBoxForTime;
    private final DefaultComboBoxModel<Object> docNames = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Object> specializationBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Object> timeSlotBoxModel = new DefaultComboBoxModel<>();

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            Key key = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    Bookings() {
        JLabel patientDetails = new JLabel("Patient Details");
        patientDetails.setFont(new Font("Arial", Font.BOLD, 25));
        patientDetails.setForeground(Color.GREEN);
        patientDetails.setBounds(930, 55, 300, 100);

        textFieldForFirstName = new JTextField();
        textFieldForFirstName.setBounds(790, 150, 200, 40);
        textFieldForFirstName.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldForFirstName.setBackground(new Color(207, 205, 202));

        JLabel forFirstName = new JLabel("First Name");
        forFirstName.setBounds(640, 150, 100, 35);
        forFirstName.setFont(new Font("Calibri", Font.PLAIN, 18));

        textFieldForSurname = new JTextField();
        textFieldForSurname.setBounds(1190, 150, 200, 40);
        textFieldForSurname.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldForSurname.setBackground(new Color(207, 205, 202));

        JLabel forSurName = new JLabel("Surname");
        forSurName.setBounds(1040, 150, 100, 35);
        forSurName.setFont(new Font("Calibri", Font.PLAIN, 18));

        labelFieldForDOB = new JLabel();
        labelFieldForDOB.setBounds(790, 230, 150, 35);
        labelFieldForDOB.setFont(new Font("Arial", Font.PLAIN, 18));
        labelFieldForDOB.setBackground(new Color(207, 205, 202));
        labelFieldForDOB.setOpaque(true);

        JButton calenderBtn = new JButton();
        calenderBtn.setBounds(945, 230, 50, 40);
        calenderBtn.setIcon(new ImageIcon("calendar.png"));
        calenderBtn.addActionListener(ae -> labelFieldForDOB.setText(new DateSelection(this).setSelectedDate()));

        JLabel forDOB = new JLabel("Date Of Birth");
        forDOB.setBounds(640, 230, 150, 35);
        forDOB.setFont(new Font("Calibri", Font.PLAIN, 18));

        textFieldForMobileNumber = new JTextField();
        textFieldForMobileNumber.setBounds(1190, 230, 200, 40);
        textFieldForMobileNumber.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldForMobileNumber.setBackground(new Color(207, 205, 202));

        JLabel forMobile = new JLabel("Mobile Number");
        forMobile.setBounds(1040, 230, 150, 35);
        forMobile.setFont(new Font("Calibri", Font.PLAIN, 18));

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 18));
        gender.setSize(100, 20);
        gender.setLocation(640, 310);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(790, 310);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(900, 310);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JSeparator jSeparator = new JSeparator();
        jSeparator.setOrientation(SwingConstants.HORIZONTAL);
        jSeparator.setBounds(640, 340, 1200, 10);
        jSeparator.setBackground(new Color(33, 255, 0));

        JLabel addConsultation = new JLabel("Add Consultation");
        addConsultation.setFont(new Font("Arial", Font.BOLD, 25));
        addConsultation.setForeground(Color.GREEN);
        addConsultation.setBounds(930, 360, 300, 50);

        JLabel selectDocLabel = new JLabel("Select a Doctor");
        selectDocLabel.setBounds(1040, 430, 150, 35);
        selectDocLabel.setFont(new Font("Calibri", Font.PLAIN, 18));

        JLabel labelForSpec = new JLabel("Specialization");
        labelForSpec.setBounds(640, 430, 150, 35);
        labelForSpec.setFont(new Font("Calibri", Font.PLAIN, 18));

        JLabel forDate = new JLabel("Pick a Date");
        forDate.setBounds(640, 510, 120, 35);
        forDate.setFont(new Font("Calibri", Font.PLAIN, 18));

        labelForconsultDate = new JLabel();
        labelForconsultDate.setBounds(790, 510, 150, 35);
        labelForconsultDate.setFont(new Font("Arial", Font.PLAIN, 18));
        labelForconsultDate.setBackground(new Color(207, 205, 202));
        labelForconsultDate.setOpaque(true);

        JButton calenderBtn2 = new JButton();
        calenderBtn2.setBounds(945, 510, 50, 40);
        calenderBtn2.setIcon(new ImageIcon("calendar.png"));
        calenderBtn2.addActionListener(ae -> labelForconsultDate.setText(new DateSelection(this).setSelectedDate()));

        JLabel labelForDuration = new JLabel("Consultation Time");
        labelForDuration.setBounds(1040, 510, 150, 35);
        labelForDuration.setFont(new Font("Calibri", Font.PLAIN, 18));

        JLabel labelForNote = new JLabel("Add Notes");
        labelForNote.setBounds(640, 590, 100, 35);
        labelForNote.setFont(new Font("Calibri", Font.PLAIN, 18));

        textAreaForNotes = new JTextArea();
        textAreaForNotes.setLineWrap(true);
        textAreaForNotes.setFont(new Font("Arial", Font.PLAIN, 15));
        textAreaForNotes.setBackground(new Color(207, 205, 202));
        textAreaForNotes.setOpaque(true);

        JScrollPane textAreaScroll = new JScrollPane(textAreaForNotes);
        textAreaScroll.setBounds(790, 590, 200, 75);

        String EncryptedNotes = encrypt(textAreaForNotes.getText(), "mySecretKey");

        this.setTitle("Book Consultation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(LeftPanel());
        this.add(RightUpperPanel());
        this.add(textFieldForFirstName);
        this.add(patientDetails);
        this.add(forFirstName);
        this.add(textFieldForSurname);
        this.add(forSurName);
        this.add(forDOB);
        this.add(forMobile);
        this.add(textFieldForMobileNumber);
        this.add(labelFieldForDOB);
        this.add(calenderBtn);
        this.add(jSeparator);
        this.add(addConsultation);
        this.add(selectDocLabel);
        this.add(DoctorNames());
        this.add(labelForSpec);
        this.add(forDate);
        this.add(labelForconsultDate);
        this.add(calenderBtn2);
        this.add(labelForDuration);
        this.add(labelForNote);
        this.add(textAreaScroll);
        this.add(Book());
        this.add(ResetButton());
        this.add(ListOfAppointments());
        this.add(RightDownPanel());
        this.add(gender);
        this.add(male);
        this.add(female);
        this.add(DoctorSpecialization());
        this.add(TimeSlot());
    }

    private JPanel LeftPanel() {
        final JLabel jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon("Consultation.jpg"));
        jLabel.setBounds(0, 0, 600, 800);

        final JLabel footer = new JLabel("Westminster Skin Consultation");
        footer.setBounds(300, 720, 250, 50);
        footer.setFont(new Font("Calibri", Font.BOLD, 15));

        final JPanel jPanel = new JPanel();
        jPanel.setBounds(0, 0, 600, 800);
        jLabel.add(footer);
        jPanel.add(jLabel);
        return jPanel;
    }

    private JPanel RightUpperPanel() {
        HomepageBtn = new JButton();
        HomepageBtn.setBounds(700, 5, 50, 50);
        HomepageBtn.setIcon(new ImageIcon("HomeIcon.png"));
        HomepageBtn.addActionListener(e -> {
            if (e.getSource() == HomepageBtn) {
                HomepageBtn.setBackground(new Color(210, 0, 0));
                this.dispose();
                new HomePage();
            }
        });
        JLabel label = new JLabel("Book a Consultation");
//        label.setIcon(new ImageIcon("ConsultationIcon.png"));
        label.setBounds(300, 5, 840, 50);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("Calibri", Font.BOLD, 30));

        final JLabel jLabel = new JLabel();
        jLabel.setBounds(0, 0, 840, 70);
        jLabel.setIcon(new ImageIcon("Rightupper.jpg"));
        jLabel.add(HomepageBtn);

        final JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 0, 840, 70);
        jPanel.add(jLabel);
        jLabel.add(label);
        return jPanel;
    }

    private JComboBox DoctorNames() {
        comboBoxForDocName = new JComboBox(docNames);
        comboBoxForDocName.setBounds(1190, 423, 200, 50);
        comboBoxForDocName.setFont(new Font("Arial", Font.PLAIN, 15));
        return comboBoxForDocName;
    }

    private JComboBox DoctorSpecialization() {
        int count = WestminsterSkinConsultationManager.list.size();
        String[] specialization = new String[count];
        int iteration = 0;
        for (Doctor doc :
                WestminsterSkinConsultationManager.list) {
            specialization[iteration] = doc.getspecialization();
            iteration++;
        }

        specializationBoxModel.addElement("Select Specialization");
        docNames.addElement("Select Doctor");

        //removing all the duplicate elements in the array
        for (int i = 0; i < count; i++) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (specialization[i].equals(specialization[j])) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                specializationBoxModel.addElement(specialization[i]);
            }
        }

        comboForSpecialization = new JComboBox(specializationBoxModel);
        comboForSpecialization.setBounds(790, 423, 200, 50);
        comboForSpecialization.setFont(new Font("Arial", Font.PLAIN, 15));
        comboForSpecialization.addActionListener(ae -> {
            if (ae.getSource() == comboForSpecialization) {
                docNames.removeAllElements();
                for (Doctor doctor :
                        WestminsterSkinConsultationManager.list) {
                    if (doctor.getspecialization().equals(comboForSpecialization.getSelectedItem())) {
                        docNames.addElement(doctor.getname() + " " + doctor.getsurname());
                    }
                }
            }
        });
        return comboForSpecialization;
    }

    private JButton Book() {
        JButton book = new JButton("Book Consultation");
        book.setBounds(1250, 705, 150, 35);
        book.setFont(new Font("Calibri", Font.BOLD, 12));
        book.setForeground(Color.BLUE);
        book.addActionListener(ae -> {
            if (ae.getSource() == book) {
                if (!textFieldForFirstName.getText().isEmpty() && !textFieldForSurname.getText().isEmpty() && !labelFieldForDOB.getText().isEmpty() && !textFieldForMobileNumber.getText().isEmpty()) {
                    String fName = textFieldForFirstName.getText();
                    String lName = textFieldForSurname.getText();
                    try {
                        dob = labelFieldForDOB.getText();
                        date = WestminsterSkinConsultationManager.dateFormat.parse(dob);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String mobile = textFieldForMobileNumber.getText();

                    if (male.isSelected()) {
                        gender = "Male";
                    } else {
                        gender = "Female";
                    }
                    String specialization = (String) DoctorSpecialization().getSelectedItem();
                    String doctorName = (String) DoctorNames().getSelectedItem();
                    try {
                        selectedDate = labelForconsultDate.getText();
                        selecteddDate = WestminsterSkinConsultationManager.dateFormat.parse(selectedDate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String time = (String) TimeSlot().getSelectedItem();
                    String notes = textAreaForNotes.getText();

                    int flag = 0;

                    for (Patient patient :
                            patientList) {
                        if (fName.equalsIgnoreCase(patient.getname()) && lName.equalsIgnoreCase(patient.getsurname())) {
                            flag = 1;
                            break;
                        }
                    }
                    int yesOrNo;
                    if (flag == 1) {
                        yesOrNo = JOptionPane.showConfirmDialog(this, "Consultation Fee :- £25\nDo you want to book the consultation?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Question.png"));
                        if (yesOrNo == 0) {
                            String consultationFee = "£25";
                            Consultation consultation = new Consultation(doctorName, specialization, selecteddDate, time, notes, consultationFee);
                            Patient patient = new Patient(fName, lName, date, mobile, gender, patientList.size());
                            patientList.add(patient);
                            consultationList.add(consultation);
                            JOptionPane.showMessageDialog(this, "Your consultation reserved Successfully!", "ALERT!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        yesOrNo = JOptionPane.showConfirmDialog(this, "Consultation Fee :- £15\nPress Yes to confirm consultation?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (yesOrNo == 0) {
                            String consultationFee = "£15";
                            Consultation consultation = new Consultation(doctorName, specialization, selecteddDate, time, notes, consultationFee);
                            Patient patient = new Patient(fName, lName, date, mobile, gender, patientList.size());
                            patientList.add(patient);
                            consultationList.add(consultation);
                            JOptionPane.showMessageDialog(this, "Your consultation has been booked Successfully!", "ALERT!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    if (yesOrNo == 1) {
                        JOptionPane.showMessageDialog(this, "Consultation Cancelled!", "ALERT!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("cancelicon.png"));
                    }
                    SaveInFile();
                    Reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Please make sure you have filled all the fields.", "Error!", JOptionPane.WARNING_MESSAGE, new ImageIcon("erroricon.png"));
                }
            }
        });
        return book;
    }

    private JComboBox TimeSlot() {
        timeSlotBoxModel.addElement("Select Time");
        timeSlotBoxModel.addElement("8:00 a.m. - 9:00 a.m.");
        timeSlotBoxModel.addElement("9:00 a.m. - 10:00 a.m.");
        timeSlotBoxModel.addElement("10:00 a.m. - 11:00 a.m.");
        timeSlotBoxModel.addElement("11:00 a.m. - 12:00 a.m.");
        timeSlotBoxModel.addElement("2:00 p.m. - 3:00 p.m.");
        timeSlotBoxModel.addElement("3:00 p.m. - 4:00 p.m.");
        timeSlotBoxModel.addElement("4:00 p.m. - 5:00 p.m.");
        timeSlotBoxModel.addElement("5:00 p.m. - 6:00 p.m.");

        jComboBoxForTime = new JComboBox(timeSlotBoxModel);
        jComboBoxForTime.setBounds(1190, 503, 200, 50);
        jComboBoxForTime.setFont(new Font("Arial", Font.PLAIN, 15));
        jComboBoxForTime.addActionListener(ae -> {
            if (ae.getSource() == jComboBoxForTime) {
                if (DoctorAvailable()) {
                    var yesOrNo = JOptionPane.showConfirmDialog(this, "Doctor is not available at this time.\nDo you want to book another the doctor for this time?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (yesOrNo == 0) {
                        docNames.removeAllElements();
                        for (Doctor doc :
                                WestminsterSkinConsultationManager.list) {
                            String name = doc.getname() + " " + doc.getsurname();
                            if (doc.getspecialization().equals(comboForSpecialization.getSelectedItem()) && !name.equalsIgnoreCase(nameOfTheSelectedDoctor)) {
                                for (Consultation consultation:
                                        consultationList) {
                                    if (name.equalsIgnoreCase(consultation.getname()) && comboForSpecialization.getSelectedItem().equals(consultation.getspecialization())){
                                        try {
                                            if (consultation.gettimeslot().equals(jComboBoxForTime.getSelectedItem()) && WestminsterSkinConsultationManager.dateFormat.parse(labelForconsultDate.getText()).equals(consultation.getdate())){
                                            }
                                            else {
                                                docNames.addElement(name);
                                                break;
                                            }
                                        } catch (ParseException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                    else {
                                        docNames.addElement(name);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (yesOrNo == 1) {

                    }
                }
            }
        });
        return jComboBoxForTime;
    }

    private boolean DoctorAvailable() {
        for (Consultation consultation :
                consultationList) {
            try {
                if (consultation.gettimeslot().equals(jComboBoxForTime.getSelectedItem()) &&
                        Objects.equals(comboBoxForDocName.getSelectedItem(), consultation.getDoctorName()) &&
                        Objects.equals(comboForSpecialization.getSelectedItem(), consultation.getspecialization()) &&
                        WestminsterSkinConsultationManager.dateFormat.parse(labelForconsultDate.getText()).equals(consultation.getdate())) {
                    nameOfTheSelectedDoctor = (String) comboBoxForDocName.getSelectedItem();
                    return true;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    private JPanel RightDownPanel() {
        final JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 760, 840, 20);
        jPanel.setBackground(new Color(123, 173, 244));
        return jPanel;
    }

    private JButton ListOfAppointments() {
        JButton listOfAppointment = new JButton("Appointments List");
        listOfAppointment.setBounds(640, 705, 200, 35);
        listOfAppointment.setFont(new Font("Calibri", Font.BOLD, 12));
        listOfAppointment.setForeground(Color.BLUE);
        listOfAppointment.addActionListener(ae -> {
            if (ae.getSource() == listOfAppointment) {
                new AppointmentsList();
            }
        });
        return listOfAppointment;
    }

    private JButton ResetButton() {
        JButton reset = new JButton("Reset");
        reset.setBounds(1090, 705, 150, 35);
        reset.setFont(new Font("Calibri", Font.BOLD, 12));
        reset.setForeground(Color.BLUE);
        reset.addActionListener(ae -> {
            if (ae.getSource() == reset) {
                Reset();
            }
        });
        return reset;
    }

    private void Reset() {
        String def = "";
        textFieldForFirstName.setText(def);
        textFieldForSurname.setText(def);
        textFieldForMobileNumber.setText(def);
        labelFieldForDOB.setText(def);
        labelForconsultDate.setText(def);
        textAreaForNotes.setText(def);
        specializationBoxModel.removeAllElements();
        DoctorSpecialization();
        DoctorNames();
        timeSlotBoxModel.removeAllElements();
        TimeSlot();
        labelForconsultDate.setText(def);
        textAreaForNotes.setText(def);
    }

    public static void SaveInFile() {
        try {
            FileOutputStream fo = new FileOutputStream("PatientList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Patient patient :
                    patientList) {
                oos.writeObject(patient);
            }
            fo.close();
            oos.close();


            FileOutputStream fo1 = new FileOutputStream("Consultation.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fo1);

            for (Consultation consultation :
                    consultationList) {
                oos1.writeObject(consultation);
            }
            fo1.close();
            oos1.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void LoadFromFile(ArrayList<Patient> listOfPatients, ArrayList<Consultation> listOfConsultation) {
        try {
            FileInputStream fis = new FileInputStream("PatientList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            FileInputStream fis1 = new FileInputStream("Consultation.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            while (true) {
                try {
                    Patient patient = (Patient) ois.readObject();
                    Consultation consultation = (Consultation) ois1.readObject();
                    listOfPatients.add(patient);
                    listOfConsultation.add(consultation);
                } catch (Exception e) {
                    break;
                }
            }
            fis1.close();
            ois1.close();
            fis.close();
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}