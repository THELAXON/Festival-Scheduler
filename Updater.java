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
    private JLabel eventlabel = new JLabel("Event:");
    private JTextField  eventfield = new JTextField();
    private JLabel durationlabel = new JLabel("Duration:");
    private JTextField  durationfield = new JTextField("in mins");
    private JLabel prioritylabel = new JLabel("Priority:");
    private String[] prioritynum = {"1","2","3","4","5","6"};
    private JComboBox<String> prioritydropdownBox = new JComboBox<>(prioritynum);
    private JButton ubutton = new JButton("Update");

    public Updater(){
        panel.add(ubutton);
        ubutton.addActionListener(this);
        panel.add(eventform);
        panel.add(eventlabel);
        panel.add(durationlabel);
        panel.add(prioritylabel);
        panel.add(eventfield);
        panel.add(durationfield);
        panel.add(prioritydropdownBox);
        eventform.setBounds(200,50,100,75);
        eventlabel.setBounds(125,150,75,25);
        durationlabel.setBounds(125,200,75,25);
        prioritylabel.setBounds(125,250,75,25);
        eventfield.setBounds(210,150,200,25);
        durationfield.setBounds(210,200,100,25);
        prioritydropdownBox.setBounds(210,250,50,25);
        ubutton.setBounds(180,300,100,25);
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public String geteventtexString(){
        String eventtext = eventfield.getText();
        return eventtext;
        
    }
    public String getdurationtexString(){
        String durationtext = durationfield.getText();
        return durationtext;
        
    }
    public String getpriorString(){
        String prioritydroptext = (String) prioritydropdownBox.getSelectedItem();
        return prioritydroptext;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ubutton){
            new Menu();
            frame.dispose();

        }
        if(e.getSource()== prioritydropdownBox){
            System.out.println(prioritydropdownBox.getSelectedIndex());
        }
        
    }
}