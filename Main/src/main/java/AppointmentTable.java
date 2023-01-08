import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;


public class AppointmentTable extends AbstractTableModel {
    private final String[] columnName = {"Patient ID", "Patient's First Name", "Patient's Last Name", "Date Of Birth", "Gender", "Mobile Number", "Name of Doctor", "Specialization", "Consult date", "Consult Time", "Consult Fee","Notes"};
    private final ArrayList<Patient> patientList;
    private final ArrayList<Consultation> consultationList;

    AppointmentTable(ArrayList<Patient> listOfPatients, ArrayList<Consultation> consultationList) {
        this.patientList = listOfPatients;
        this.consultationList = consultationList;
    }

    @Override
    public int getRowCount() {
        return patientList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = patientList.get(rowIndex).getid();
        } else if (columnIndex == 1) {
            temp = patientList.get(rowIndex).getname();
        } else if (columnIndex == 2) {
            temp = patientList.get(rowIndex).getsurname();
        }else if (columnIndex == 3) {
            temp = patientList.get(rowIndex).getdateofbirth();
        } else if (columnIndex == 4) {
            temp = patientList.get(rowIndex).getgender();
        } else if (columnIndex == 5) {
            temp = patientList.get(rowIndex).getmobilenumber();
        } else if (columnIndex == 6) {
            temp = consultationList.get(rowIndex).getDoctorName();
        } else if (columnIndex == 7) {
            temp = consultationList.get(rowIndex).getspecialization();
        } else if (columnIndex == 8) {
            temp = consultationList.get(rowIndex).getdate();
        } else if (columnIndex == 9) {
            temp = consultationList.get(rowIndex).gettimeslot();
        } else if (columnIndex == 10) {
            temp = consultationList.get(rowIndex).getcost();
        }else if (columnIndex == 11) {
            temp = consultationList.get(rowIndex).getnotes();
        }
        return temp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Patient row = Bookings.patientList.get(rowIndex);
        if (0 == columnIndex) {
            row.setid((Integer) aValue);
        } else if (1 == columnIndex) {
            row.setname((String) aValue);
        } else if (2 == columnIndex) {
            row.setsurname((String) aValue);
        } else if (3 == columnIndex) {
            row.setdateofbirth((Date) aValue);
        } else if (4 == columnIndex) {
            row.setgender((String) aValue);
        }  else if (5 == columnIndex) {
            row.setmobilenumber((String) aValue);
        } else if (6 == columnIndex) {
            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
        } else if (7 == columnIndex) {
            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
        } else if (8 == columnIndex) {
            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
        } else if (9 == columnIndex) {
            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
        }else if (10 == columnIndex) {
            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
        }else if (11 == columnIndex) {
            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
        }
        Bookings.SaveInFile();
    }

    public String getColumnName(int col) {
        return columnName[col];
    }

    public Class getColumnClass(int col) {
        if (col == 0) {
            return int.class;
        } else if (col == 1) {
            return String.class;
        } else if (col == 2) {
            return String.class;
        } else if (col == 3) {
            return Date.class;
        } else if (col == 4) {
            return String.class;
        } else if (col == 5) {
            return String.class;
        } else if (col == 6) {
            return String.class;
        } else if (col == 7) {
            return String.class;
        } else if (col == 8) {
            return Date.class;
        } else if (col == 9) {
            return String.class;
        } else if (col == 10) {
            return String.class;
        } else if (col == 11) {
            return String.class;
        } else {
            return null;
        }
    }
}