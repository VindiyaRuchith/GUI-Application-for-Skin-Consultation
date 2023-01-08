import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class InformationList extends JFrame {
    private JButton HomepageBtn;
    private JButton sortButton;
    private ArrayList<Doctor> docList = new ArrayList<>();
    private JTable table;

    InformationList() {
        //Code for Frame implementation
        this.setTitle("Doctor List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440,800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(UpperPanel());
        this.add(LowerPanel());
        this.add(RightPanel());
        this.add(LeftPanel());
        this.add(ScrollPane());
    }
    
    public void setDocList(ArrayList<Doctor> listOfDoc) {
    docList = listOfDoc;
}
    


    /**
     * Code for Top Panel
     * @return JPanel
     */
     private JPanel UpperPanel() {
         final JPanel upperPanel;
         final JLabel upperLabel;

         HomepageBtn = new JButton();
         HomepageBtn.setBounds(1270,35,50,50);
         HomepageBtn.setIcon(new ImageIcon("HomeIcon.png"));
         HomepageBtn.addActionListener(e -> {
             if (e.getSource() == HomepageBtn){
                 HomepageBtn.setBackground(new Color(224,213,247));
                 this.dispose();
                 new HomePage();
             }
         });
         
         sortButton = new JButton("Sort");
         sortButton.setBounds(1200, 35, 50, 50);
         sortButton.setIcon(new ImageIcon("sorticon.png"));
         sortButton.addActionListener(e -> {
             if (e.getSource() == sortButton) {
                 Collections.sort(docList);
                 table.repaint();
             }
         });
         
        

         JLabel label = new JLabel("Doctor Information List");
         label.setIcon(new ImageIcon("cross.png"));
         label.setBounds(68,35,450,70);
         label.setForeground(Color.GREEN);
         label.setFont(new Font("Calibri",Font.ITALIC,30));

         upperLabel = new JLabel(new ImageIcon("listu.jpg"));
         upperLabel.setBounds(0, 0, 1440, 120);

         upperPanel = new JPanel();
         upperPanel.setBounds(0,0,1440,120);
         upperPanel.add(upperLabel);
         upperLabel.add(label);
         upperLabel.add(HomepageBtn);
         upperLabel.add(sortButton);
         return upperPanel;
     }

    /**
     * Codes that contains the right panel
     * @return JPanel
     */
    private JPanel RightPanel(){
        JPanel rightSidePanel;
        JLabel rightLabel;

        rightLabel = new JLabel(new ImageIcon("lists.jpg"));
        rightLabel.setBounds(0, 0, 70, 580);
        rightSidePanel = new JPanel();
        rightSidePanel.setBounds(1370,120, 70, 580);
        rightSidePanel.add(rightLabel);

        return rightSidePanel;
    }

    /**
     * Codes that contain the Left panel
     * @return JPanel
     */
    private JPanel LeftPanel(){
        JPanel leftSidePanel;
        JLabel leftLabel;

        leftLabel = new JLabel(new ImageIcon("lists.jpg"));
        leftLabel.setBounds(0,0, 70, 580);
        leftSidePanel = new JPanel();
        leftSidePanel.setBounds(0,120, 70, 580);
        leftSidePanel.add(leftLabel);

        return leftSidePanel;
    }

    /**
     * Codes that contain bottom panel
     * @return JPanel
     */
    private JPanel LowerPanel(){
        JPanel lowerPanel;
        JLabel lowerLabel;

        JLabel footer = new JLabel("Westminster Skin Consultation");
        footer.setBounds(650,30, 250,20);
        footer.setFont(new Font("Calibri", Font.BOLD,15));

        lowerLabel = new JLabel(new ImageIcon("listl.jpg"));
        lowerLabel.setBounds(0, 0,1440, 75);
        lowerPanel = new JPanel();
        lowerPanel.setBounds(0, 700, 1440,75);
        lowerLabel.add(footer);
        lowerPanel.add(lowerLabel);

        return lowerPanel;
    }

    /**
     * Code for JScrollPane
     * @return JScrollPane
     */
    private JScrollPane ScrollPane(){
        final JScrollPane scrollPane;
        //Create object of a custom table
        ListTable model = new ListTable(WestminsterSkinConsultationManager.list);

        //Defining the table
        JTable table = new JTable(model);
        table.setBackground(Color.CYAN);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(85,181,183));
        table.setSelectionForeground(Color.GREEN);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Calibri", Font.ITALIC,13));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Calibri",Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(90,50));
        table.getTableHeader().setForeground(new Color(255, 0, 78));
        table.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70,120,1300,583);
        return scrollPane;
    }
}
