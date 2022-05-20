import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.time.LocalTime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Menu implements ActionListener
{

    private Updater update = new Updater();
    //private Start start = new Start();
    static int rowcount = Integer.parseInt(Start.geteventtexString());
    static int start = Integer.parseInt(Start.geteventtexString());
    private int headlinerhour = Integer.parseInt(Start.getheadlinerhourString());
    private int headlinermin = Integer.parseInt(Start.getheadlinerminString());
    private JFrame frame = new JFrame("Festival Scheduling Timetable");
    private JPanel bpanel = new JPanel();
    private JPanel tablepanel = new JPanel();
    private JButton ebutton = new JButton("Edit");
    private JButton sbutton = new JButton("Sort");
    private JButton fbutton = new JButton("File");
    private String[] columns = {"Event","Duration","Break","Priority","Start Time","End Time"};
    private static String[][] data = new String[rowcount][5];
    DefaultTableModel model = new DefaultTableModel(data,columns) ;
    private JTable  timetable = new JTable(model);
    int count = 0;
    int timecount = 0;
    private JButton ubutton = Updater.getuButton();
    public Menu(){
        update.visiblesetf();
        ebutton.addActionListener(this);
        bpanel.add(sbutton);
        bpanel.add(ebutton);
        bpanel.add(fbutton);
        sbutton.addActionListener(sbuttonlistener);
        ubutton.addActionListener(ubuttonlistener);
        fbutton.addActionListener(fbuttonlistener);
        ebutton.setBounds(80,0,100,25);
        sbutton.setBounds(180,0,100,25);
        fbutton.setBounds(280,0,100,25);
        tablepanel.add(timetable);
        tablepanel.add(new JScrollPane(timetable));
        model.setColumnIdentifiers(columns);
        tablepanel.setBounds(0,0,450,300);
        bpanel.setLayout(null);
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
                sortdata(data);
                for(int y=0; y<rowcount;)
                {
                    model.setValueAt(data[y][0],y,0);
                    model.setValueAt(data[y][1],y,1);
                    model.setValueAt(data[y][2],y,2);
                    model.setValueAt(data[y][3],y,3);
                    y++;
                }
                timesorter(data, headlinerhour, headlinermin);

                for(int y=0; y<rowcount;)
                {
                    model.setValueAt(data[y][4],y,4);
                    y++;
                }

                System.out.println(Arrays.deepToString(data));
            }
        }
    };
    ActionListener fbuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== fbutton)
            {
                int y = 0;

                String file = "demo.csv";
                String line = "";
                try 
                {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while((line = reader.readLine()) != null)
                    {
                        String[] values = line.split(",");
                        data[y][0] = values[0];
                        data[y][1] = values[1];
                        data[y][2] = values[2];
                        data[y][3] = values[3];
                        model.setValueAt(data[y][0],y,0);
                        model.setValueAt(data[y][1],y,1);
                        model.setValueAt(data[y][2],y,2);
                        model.setValueAt(data[y][3],y,3);
                        y++;
                    }
                } catch (FileNotFoundException p) 
                {
                    p.printStackTrace();
                } catch (IOException p) 
                {
                    p.printStackTrace();
                }
                
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
                data[count][1] = Updater.getdurationString();
                data[count][2] = Updater.getbreakString();
                data[count][3] = Updater.getpriorString();

                model.setValueAt(data[count][0],count,0);
                model.setValueAt(data[count][1],count,1);
                model.setValueAt(data[count][2],count,2);
                model.setValueAt(data[count][3],count,3);
                count++;
                System.out.println(Arrays.deepToString(data));
            }
        }
    };

    public static void timesorter(String[][] data, int headlinerhour, int headlinermin)
    {
        LocalTime starttime = LocalTime.of(headlinerhour,headlinermin);
        System.out.println(starttime); 

        for(int g=0; g<rowcount;)
        {
        int finaladd=Integer.parseInt(data[g][1]) + Integer.parseInt(data[g][2]);
        LocalTime updatedtime = starttime.plusMinutes(finaladd);
        starttime = updatedtime;
        data[g][4] = updatedtime.toString();
        g++;
        }


    }

    public static void sortdata(String[][] data) 
    {
        String tevent, tprior, tduration, tbreak;
        boolean sorted = false;
    
        while (!sorted) {
            sorted = true;
            for (int i = 0 ; i < data.length - 1 ; i++) {
                if (Integer.parseInt(data[i][3]) > Integer.parseInt(data[i+1][3])){
                    sorted = false;
                    // SWAP EVENTS
                    tevent = data[i][0];
                    data[i][0] = data[i+1][0];
                    data[i+1][0] = tevent;
                    // SWAP DURATIONS
                    tduration = data[i][1];
                    data[i][1] = data[i+1][1];
                    data[i+1][1] = tduration;
                    // SWAP BREAKS
                    tbreak = data[i][2];
                    data[i][2] = data[i+1][2];
                    data[i+1][2] = tbreak;
    
                    // SWAP PRIORITIES
                    tprior = data[i][3];
                    data[i][3] = data[i+1][3];
                    data[i+1][3] = tprior;
                }
            }
        }
    }
}