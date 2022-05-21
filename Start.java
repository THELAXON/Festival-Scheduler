import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the start class where the person enters the start time where 1 jtextfield is for the hour and the second for the minutes
 * The Number of events is the second jtextfield to know the number of events that will take place on the day so appropriate number of rows are inserted into the jtable
 * This class has a single button:
 * Update = This button is linked to menu class and will take the number of events as a value of this class as input
 **/

public class Start implements ActionListener
{

    private JFrame frame = new JFrame("Festival Scheduling Updater");
    private JPanel panel = new JPanel();
    private JLabel welcome = new JLabel("Welcome");
    private JLabel Headliner = new JLabel("Headliner Time:");
    private static JTextField  Headlinerhourfield = new JTextField();
    private JLabel dot = new JLabel(":");
    private static JTextField  Headlinerminfield = new JTextField();
    private JLabel events = new JLabel("Number of Events:");
    private static JTextField numevents  = new JTextField();
    private static JButton button = new JButton("Menu");

    public Start(){
        panel.add(button);
        button.addActionListener(this);
        panel.add(welcome);
        panel.add(Headliner);
        panel.add(dot);
        panel.add(events);
        panel.add(Headlinerhourfield);
        panel.add(Headlinerminfield);
        panel.add(numevents);
        welcome.setBounds(200,50,100,75);
        Headliner.setBounds(120,150,150,25);
        events.setBounds(120,200,150,25);
        Headlinerhourfield.setBounds(250,150,30,25);
        dot.setBounds(281,150,30,25);
        Headlinerminfield.setBounds(285,150,30,25);
        numevents.setBounds(250,200,100,25);
        button.setBounds(180,300,100,25);
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static JButton getuButton(){
        return button;
    }
    public void visiblesetf(){
        frame.setVisible(false);
    }
    public void visiblesett(){
        frame.setVisible(true);
    }

    public static String getheadlinerhourString(){
        String headlinerhourfield = Headlinerhourfield.getText();
        return headlinerhourfield;
        
    }
    public static String getheadlinerminString(){
        String headlinerminfield = Headlinerminfield.getText();
        return headlinerminfield;
        
    }
    public static String geteventtexString(){
        String events = numevents.getText();
        return events;  
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        new Menu();
        frame.setVisible(false);
    }
}