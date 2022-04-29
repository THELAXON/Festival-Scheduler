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
    private JLabel timelabel = new JLabel("Time Length:");
    private JTextField  timefield = new JTextField("in mins");
    private JLabel prioritylabel = new JLabel("Priority:");
    Integer[] prioritynum = {1,2,3,4,5,6};
    private JComboBox<Integer> prioritydropdownBox = new JComboBox<>(prioritynum);
    private JButton ubutton = new JButton("Update");
    //private String[] data = new String[3];

    public Updater(){
        panel.add(ubutton);
        ubutton.addActionListener(this);
        panel.add(eventform);
        panel.add(eventlabel);
        panel.add(timelabel);
        panel.add(prioritylabel);
        panel.add(eventfield);
        panel.add(timefield);
        panel.add(prioritydropdownBox);
        eventform.setBounds(200,50,100,75);
        eventlabel.setBounds(125,150,75,25);
        timelabel.setBounds(125,200,75,25);
        prioritylabel.setBounds(125,250,75,25);
        eventfield.setBounds(210,150,200,25);
        timefield.setBounds(210,200,100,25);
        prioritydropdownBox.setBounds(210,250,50,25);
        ubutton.setBounds(180,300,100,25);
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
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