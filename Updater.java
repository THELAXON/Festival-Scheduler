import javax.swing.*;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Arrays;


public class Updater implements ActionListener
{

    private JFrame frame = new JFrame("Festival Scheduling Updater");
    private JPanel panel = new JPanel();
    private JLabel eventform = new JLabel("Event Form");
    private JLabel eventlabel = new JLabel("Event Name:");
    private static JTextField  eventfield = new JTextField();
    private JLabel breaklabel = new JLabel("Break(mins):");
    private static JTextField  breakfield = new JTextField();
    private JLabel durationlabel = new JLabel("Duration(mins):");
    private static JTextField  durationfield = new JTextField();
    private JLabel prioritylabel = new JLabel("Priority:");
    private static String[] prioritynum = {"1","2","3","4","5","6"};
    private static JComboBox<String> prioritydropdownBox = new JComboBox<>(prioritynum);
    private static JButton ubutton = new JButton("Update");

    public Updater(){
        panel.add(ubutton);
        ubutton.addActionListener(this);
        panel.add(eventform);
        panel.add(eventlabel);
        panel.add(durationlabel);
        panel.add(breaklabel);
        panel.add(prioritylabel);
        panel.add(eventfield);
        panel.add(durationfield);
        panel.add(breakfield);
        panel.add(prioritydropdownBox);
        eventform.setBounds(200,25,100,75);
        eventlabel.setBounds(120,100,75,25);
        durationlabel.setBounds(120,150,100,25);
        breaklabel.setBounds(120,200,100,25);
        prioritylabel.setBounds(120,250,75,25);
        eventfield.setBounds(210,100,150,25);
        durationfield.setBounds(210,150,100,25);
        breakfield.setBounds(210,200,100,25);
        prioritydropdownBox.setBounds(210,250,50,25);
        ubutton.setBounds(180,300,100,25);
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static JButton getuButton(){
        return ubutton;
    }
    public void visiblesetf(){
        frame.setVisible(false);
    }
    public void visiblesett(){
        frame.setVisible(true);
    }

    public static String geteventtexString(){
        String eventtext = eventfield.getText();
        return eventtext;
        
    }
    public static String getdurationString(){
        String durationtext = durationfield.getText();
        return durationtext;
        
    }
    public static String getbreakString(){
        String breaktext = breakfield.getText();
        return breaktext;
        
    }
    public static String getpriorString(){
        String prioritydroptext = (String) prioritydropdownBox.getSelectedItem();
        return prioritydroptext;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== prioritydropdownBox){
            System.out.println(prioritydropdownBox.getSelectedIndex());
        }
        
    }
}