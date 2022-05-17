import javax.swing.*;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Arrays;


public class Start implements ActionListener
{

    private JFrame frame = new JFrame("Festival Scheduling Updater");
    private JPanel panel = new JPanel();
    private JLabel welcome = new JLabel("Welcome");
    private JLabel Headliner = new JLabel("Headliner:");
    private static JTextField  Headlinerfield = new JTextField();
    private JLabel events = new JLabel("Events:");
    private static JTextField numevents  = new JTextField();
    private static JButton button = new JButton("Menu");

    public Start(){
        panel.add(button);
        button.addActionListener(this);
        panel.add(welcome);
        panel.add(Headliner);
        panel.add(events);
        panel.add(Headlinerfield);
        panel.add(numevents);
        welcome.setBounds(200,50,100,75);
        Headliner.setBounds(125,150,75,25);
        events.setBounds(125,200,75,25);
        Headlinerfield.setBounds(210,150,200,25);
        numevents.setBounds(210,200,100,25);
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

    public static String getheadlinerString(){
        String headlinerfield = Headlinerfield.getText();
        return headlinerfield;
        
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