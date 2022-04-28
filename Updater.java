import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Updater implements ActionListener
{
    private JFrame frame = new JFrame("Festival Scheduling");
    private JPanel menupanel = new JPanel();
    private JPanel bpanel = new JPanel();
    private JButton ubutton = new JButton();
    private String[] data = new String[3];

    public Updater(){
        frame.add(ubutton);
        frame.add(bpanel);
        frame.add(menupanel);
        ubutton.setVisible(true);
        menupanel.setBounds(0,0,400,400);
        bpanel.setBounds(250,450,50,50);
        bpanel.setLayout(new GridLayout(1,1,0,0));
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ubutton){
            new Menu();
            frame.dispose();
        }
        
    }
}