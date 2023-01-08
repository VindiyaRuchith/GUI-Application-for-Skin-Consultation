import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

class ListTable extends AbstractTableModel {
    private final String[] columnName = {"Medical License Number","Name of the doctor","Date Of Birth","Gender","Mobile Number","Specialization"};
    private final ArrayList<Doctor> docList;

    public ListTable(ArrayList<Doctor> listOfDoc){
        docList = listOfDoc;
    }

    @Override
    public int getRowCount() {
        return docList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if(columnIndex == 0){
            temp = docList.get(rowIndex).getmedicallicensenumber();
        }
        else if(columnIndex == 1){
            temp = docList.get(rowIndex).getname() + " " + docList.get(rowIndex).getsurname();
        }
        else if(columnIndex == 2){
            temp = docList.get(rowIndex).getdateofbirth();
        }
        else if(columnIndex == 3){
            temp = docList.get(rowIndex).getgender();
        }
        else if(columnIndex == 4){
            temp = docList.get(rowIndex).getmobilenumber();
        }
        else if(columnIndex == 5){
            temp = docList.get(rowIndex).getspecialization();
        }
        return temp;
    }

    public String getColumnName(int col){
        return columnName[col];
    }

    public Class getColumnClass(int col){
        if(col == 0){
            return String.class;
        }else if(col == 1){
            return String.class;
        }else if(col == 2){
            return Date.class;
        }else if(col == 3){
            return String.class;
        }else if(col == 4){
            return String.class;
        }else if(col == 5){
            return String.class;
        }
        else{
            return null;
        }
    }
}
