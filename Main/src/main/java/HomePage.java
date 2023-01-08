import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HomePage extends JFrame {
    private final JButton button1;

    public HomePage(){
        //Adding a background image
        JLabel background = new JLabel(new ImageIcon("homepage.jpg"));
        background.setBounds(0,0,1440,772);

        //Adding a heading to the page
        JLabel heading = new JLabel("Westminster Skin Consultation");
        heading.setBounds(370,25,1100,50);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Arial", Font.BOLD, 45));
        background.add(heading);

        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon("logo.png"));
        icon.setBounds(140,15,80,80);
        background.add(icon);

        //Assigning buttons
        button1 = new JButton("List Of Doctors");
        button1.setBounds(300,270,800,130);
        button1.setIcon(new ImageIcon("list.png"));
        button1.setFont(new Font("Arial",Font.ITALIC,25));
        button1.addActionListener(e -> {
            if (e.getSource() == button1){
                dispose();
                new InformationList();
            }
        });
        background.add(button1);

        //Adding a button to book consultations
        JButton button2 = new JButton("Book Consultation");
        button2.setBounds(300,450,800,130);
        button2.setIcon(new ImageIcon("booking.png"));
        button2.setFont(new Font("Arial",Font.ITALIC,25));
        button2.addActionListener(e -> {
            dispose();
            new Bookings();
        });
        background.add(button2);

        // Assigning a color to the border
        Border border = BorderFactory.createLineBorder(Color.WHITE,5);
        background.setBorder(border);

        this.setTitle("Westminster Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440,800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(background);


    }
}