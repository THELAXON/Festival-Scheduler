import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;



public class Menu implements ActionListener
{

    private Updater update = new Updater();
    private JFrame frame = new JFrame("Festival Scheduling Timetable");
    private JPanel bpanel = new JPanel();
    private JPanel tablepanel = new JPanel();
    private JButton ebutton = new JButton("Edit");
    private String[] columns = {"Event","Duration","Priority"};
    private static Object[][] data = new Object[21][3];
    DefaultTableModel model = new DefaultTableModel(data,columns) ;
    private JTable  timetable = new JTable(model);
    int count = 0;
    private JButton ubutton = Updater.getuButton();
    public Menu(){
        ubutton.addActionListener(ubuttonlistener);
        update.visiblesetf();
        tablepanel.add(timetable);
        tablepanel.add(new JScrollPane(timetable));
        model.setColumnIdentifiers(columns);

        bpanel.add(ebutton);
        ebutton.addActionListener(this);
        ebutton.setBounds(180,0,100,25);
        bpanel.setLayout(null);
        tablepanel.setBounds(0,0,450,300);
        bpanel.setBounds(0,400,500,100);
        frame.add(bpanel);
        frame.add(tablepanel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void visiblesett(){
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()== ebutton){
            update.visiblesett();
            frame.setVisible(false);
            
        }
    }
    ActionListener ubuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== ubutton)
            {
                update.visiblesetf();
                frame.setVisible(true);

                data[count][0] = update.geteventtexString();
                data[count][1] = update.getdurationtexString();
                data[count][2] = update.getpriorString();
                model.setValueAt(data[count][0],count,0);
                model.setValueAt(data[count][1],count,1);
                model.setValueAt(data[count][2],count,2);
                count++;
                //model.fireTableRowsUpdated(count, count);
                System.out.println(Arrays.deepToString(data));
            }
        }
    };
}