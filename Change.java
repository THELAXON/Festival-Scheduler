import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is the Change class where the user gets to change specicific values in the jtable
 * This class has multiple jtextfields:
 * Row and column = Takes the specific row and column that needs to be changed.
 * change to field = Grants the user the input they desire to be changed in the jtable
 * The class has a single jbutton:
 * Update = Menu class uses the values given to make appropriate changes in the jtable
 **/

public class Change implements ActionListener
{

    private JFrame frame = new JFrame("Festival Scheduling Updater");
    private JPanel panel = new JPanel();
    private JLabel changes = new JLabel("Make Changes");
    private JLabel rowandcol = new JLabel("row and column:");
    private static JTextField  rowfield = new JTextField();
    private static JTextField  colfield = new JTextField();
    private JLabel change = new JLabel("Change to Field:");
    private static JTextField changefield  = new JTextField();
    private static JButton button = new JButton("Update");

    public Change(){
        panel.add(button);
        button.addActionListener(this);
        panel.add(changes);
        panel.add(rowandcol);
        panel.add(change);
        panel.add(rowfield);
        panel.add(colfield);
        panel.add(changefield);
        changes.setBounds(200,50,100,75);
        rowandcol.setBounds(120,150,150,25);
        change.setBounds(120,200,150,25);
        rowfield.setBounds(250,150,30,25);
        colfield.setBounds(285,150,30,25);
        changefield.setBounds(250,200,100,25);
        button.setBounds(180,300,100,25);
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static JButton getcButton(){
        return button;
    }
    public void visiblesetf(){
        frame.setVisible(false);
    }
    public void visiblesett(){
        frame.setVisible(true);
    }

    public static String getrowchangefieldString(){
        String rowchangefield = rowfield.getText();
        return rowchangefield;
        
    }
    public static String getcolchangefieldString(){
        String colchangefield = colfield.getText();
        return colchangefield;
        
    }
    public static String getchangetextfieldString(){
        String changetextfield = changefield.getText();
        return changetextfield;  
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
    }
}