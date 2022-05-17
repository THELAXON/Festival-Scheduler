import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;




public class Menu implements ActionListener
{

    private Updater update = new Updater();
    //private Start start = new Start();
    static int x = Integer.parseInt(Start.geteventtexString());
    String headliner = Start.getheadlinerString();
    private JFrame frame = new JFrame("Festival Scheduling Timetable");
    private JPanel bpanel = new JPanel();
    private JPanel tablepanel = new JPanel();
    private JButton ebutton = new JButton("Edit");
    private JButton sbutton = new JButton("Sort");
    private String[] columns = {"Event","Duration","Priority"};
    private static String[][] data = new String[x][3];
    DefaultTableModel model = new DefaultTableModel(data,columns) ;
    private JTable  timetable = new JTable(model);
    int count = 0;
    int y = 0;
    private JButton ubutton = Updater.getuButton();
    //private JButton startbutton = Start.getuButton();
    public Menu(){
        //startbutton.addActionListener(startbuttonlistener);
        ubutton.addActionListener(ubuttonlistener);
        update.visiblesetf();
        tablepanel.add(timetable);
        tablepanel.add(new JScrollPane(timetable));
        model.setColumnIdentifiers(columns);

        bpanel.add(ebutton);
        ebutton.addActionListener(this);
        ebutton.setBounds(130,0,100,25);
        bpanel.add(sbutton);
        sbutton.addActionListener(sbuttonlistener);
        sbutton.setBounds(230,0,100,25);
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

    public void visiblesetf(){
        frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()== ebutton){
            update.visiblesett();
            frame.setVisible(false);
            
        }
    }
    ActionListener sbuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== sbutton)
            {
                frame.setVisible(true);
                sortdata(data);
                //Arrays.deepToString(data);
                System.out.println(Arrays.deepToString(data));
            }
        }
    };
    ActionListener ubuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== ubutton)
            {
                update.visiblesetf();
                frame.setVisible(true);

                data[count][0] = Updater.geteventtexString();
                data[count][1] = Updater.getdurationtexString();
                data[count][2] = Updater.getpriorString();
                model.setValueAt(data[count][0],count,0);
                model.setValueAt(data[count][1],count,1);
                model.setValueAt(data[count][2],count,2);
                count++;
                System.out.println(Arrays.deepToString(data));
            }
        }
    };

    public static void sortdata(String[][] data) 
    {
        String tevent, tprior;
        boolean sorted = false;
    
        while (!sorted) {
            sorted = true;
            for (int i = 0 ; i < data.length - 1 ; i++) {
                if (Integer.parseInt(data[i][2]) > Integer.parseInt(data[i+1][2])){
                    sorted = false;
                    // SWAP EVENTS
                    tevent = data[i][0];
                    data[i][0] = data[i+1][0];
                    data[i+1][0] = tevent;
    
                    // SWAP PRIORITIES
                    tprior = data[i][2];
                    data[i][2] = data[i+1][2];
                    data[i+1][2] = tprior;
                }
            }
        }
    }
}