import javax.swing.*;
import java.awt.*;

public class AppointmentsList extends JFrame {
    AppointmentsList(){
        this.setTitle("Current Booked Appointments");
        this.setSize(1300, 683);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(Table());
        this.add(UpperPanel());
        this.add(LeftPanel());
        this.add(LowerPanel());
        this.add(RightPanel());
    }

    private JPanel UpperPanel() {
        JLabel jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon("appointmentsu.jpg"));
        jLabel.setBounds(0,0,1300,85);

        JLabel jLabel1 = new JLabel();
        jLabel1.setIcon(new ImageIcon("appointmenticon.png"));
        jLabel1.setBounds(60,5,70,70);

        JLabel jlabel2 = new JLabel("Booked Consultations");
//        label.setIcon(new ImageIcon("ConsultationIcon.png"));
        jlabel2.setBounds(150, 10, 840, 50);
        jlabel2.setForeground(Color.GREEN);
        jlabel2.setFont(new Font("Calibri", Font.BOLD, 30));

        JPanel jPanel = new JPanel();
        jPanel.setBounds(0,0,1300,85);
        jLabel.add(jLabel1);
        jPanel.add(jLabel);
        jLabel.add(jlabel2);
        return jPanel;
    }

    private JPanel LeftPanel(){
        JLabel jLabel = new JLabel();
        jLabel.setBounds(0,0,60,683);
        jLabel.setIcon(new ImageIcon("appointmentsl.jpg"));

        JPanel jPanel = new JPanel();
        jPanel.setBounds(0,80,60,683);
        jPanel.add(jLabel);
        return jPanel;
    }
    private JPanel RightPanel(){
        JLabel jLabel = new JLabel();
        jLabel.setBounds(0,0,70,500);
        jLabel.setIcon(new ImageIcon("appointmentsl.jpg"));

        JPanel jPanel = new JPanel();
        jPanel.setBounds(1230,80,70,500);
        jPanel.add(jLabel);
        return jPanel;
    }

    private JPanel LowerPanel(){
        JLabel jLabel = new JLabel();
        jLabel.setBounds(0,0,1300,85);
        jLabel.setIcon(new ImageIcon("appointmentsu.jpg"));

        JPanel jPanel = new JPanel();
        jPanel.setBounds(60,580,1300,98);
        jPanel.add(jLabel);
        return jPanel;
    }

    private JScrollPane Table(){
        AppointmentTable appointmenttable = new AppointmentTable(Bookings.patientList, Bookings.consultationList );

        JTable table = new JTable(appointmenttable);
        table.setBackground(Color.CYAN);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(0x33FF00));
        table.setSelectionForeground(Color.RED);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Calibri",Font.PLAIN,14));
        table.setRowHeight(20);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(150,50));
        table.getTableHeader().setForeground(new Color(210, 0, 0));
        table.setAutoCreateRowSorter(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
        table.getColumnModel().getColumn(9).setPreferredWidth(170);
        table.getColumnModel().getColumn(10).setPreferredWidth(100);

        JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(60, 85, 1170, 500);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        return jScrollPane;
    }

}