import javax.swing.*;

import java.awt.Dimension;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Menu implements ActionListener
{
    private JFrame frame = new JFrame("Festival Scheduling Timetable");
    private JPanel bpanel = new JPanel();
    private JPanel tablepanel = new JPanel();
    private JButton ebutton = new JButton("Edit");
    private String[] columns = {"Event","Duration","Time Slot"};
    private Object[][] data = {{"Men's Rugby","120","10:00"},{"Womens hockey","100","15:00"},{"Womens hockey","100","15:00"}};
    private JTable  timetable = new JTable(data,columns);
    //private JScrollPane jsp = new JScrollPane(timetable);
    public Menu(){
    

        timetable = new JTable(data,columns);
        timetable.setPreferredScrollableViewportSize(new Dimension(450,50));
        timetable.setFillsViewportHeight(true);
        tablepanel.add(timetable);
        tablepanel.add(new JScrollPane(timetable));

        bpanel.add(ebutton);
        ebutton.addActionListener(this);
        ebutton.setBounds(180,0,100,25);
        bpanel.setLayout(null);
//     frame.setContentPane(tablepanel);
        tablepanel.setBounds(0,0,450,350);
        bpanel.setBounds(0,400,500,100);
        frame.add(bpanel);
        frame.add(tablepanel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ebutton){
            new Updater();
            frame.dispose();
            
        }
    }
}