import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.time.LocalTime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Menu implements ActionListener
{

    private Updater update = new Updater();
    private Change change = new Change();
    static int rowcount = Integer.parseInt(Start.geteventtexString());
    static int start = Integer.parseInt(Start.geteventtexString());
    private int headlinerhour = Integer.parseInt(Start.getheadlinerhourString());
    private int headlinermin = Integer.parseInt(Start.getheadlinerminString());
    private JFrame frame = new JFrame("Festival Scheduling Timetable");
    private JPanel bpanel = new JPanel();
    private JPanel tablepanel = new JPanel();
    private JButton editbutton = new JButton("Edit");
    private JButton sortbutton = new JButton("Sort");
    private JButton importbutton = new JButton("Import");
    private JButton cbutton = new JButton("Change");
    private JButton exportbutton = new JButton("Export");
    private String[] columns = {"Event","Duration","Break","Priority","Start Time","End Time"};
    private static String[][] data = new String[rowcount][6];
    DefaultTableModel model = new DefaultTableModel(data,columns) ;
    private JTable  timetable = new JTable(model);
    private JButton ubutton = Updater.getuButton();
    private JButton changebutton = Change.getcButton();
    int count = 0;
    int timecount = 0;
    public Menu(){
        update.visiblesetf();
        change.visiblesetf();
        bpanel.add(sortbutton);
        bpanel.add(editbutton);
        bpanel.add(importbutton);
        bpanel.add(cbutton);
        bpanel.add(exportbutton);
        editbutton.addActionListener(this);
        sortbutton.addActionListener(sbuttonlistener);
        ubutton.addActionListener(ubuttonlistener);
        cbutton.addActionListener(cbuttonlistener);
        changebutton.addActionListener(changebuttonlistener);
        importbutton.addActionListener(fbuttonlistener);
        exportbutton.addActionListener(ebuttonlistener);
        editbutton.setBounds(80,0,100,25);
        sortbutton.setBounds(180,0,100,25);
        cbutton.setBounds(280,0,100,25);
        importbutton.setBounds(130,25,100,25);
        exportbutton.setBounds(230,25,100,25);
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
        if(e.getSource()== editbutton){
            update.visiblesett();
            frame.setVisible(false);
            
        }
    }
     
    ActionListener sbuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== sortbutton)
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
                    model.setValueAt(data[y][5],y,5);
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
            if(e.getSource()== importbutton)
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
                    reader.close();
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

    ActionListener ebuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== exportbutton)
            {
                for(int y=0;y<rowcount;)
                {
                    String eventtitle = data[y][0];
                    String start = data[y][4];
                    String finish = data[y][5];
                    save(eventtitle,start,finish);
                    y++;
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
    ActionListener cbuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
        if(e.getSource()== cbutton){
            change.visiblesett();
            frame.setVisible(false);
            
        }
        }
    };
    ActionListener changebuttonlistener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== changebutton)
            {
                frame.setVisible(true);
                int row = Integer.parseInt(Change.getrowchangefieldString());
                int col = Integer.parseInt(Change.getcolchangefieldString());
                data[row][col] = Change.getchangetextfieldString();
                model.setValueAt(data[row][col],row,col);
                System.out.println(Arrays.deepToString(data));
            }
        }
    };

    public static void timesorter(String[][] data, int headlinerhour, int headlinermin)
    {
        LocalTime starttime = LocalTime.of(headlinerhour,headlinermin);
        System.out.println(starttime); 
        data[0][4] = starttime.toString();
        LocalTime endadd = starttime.plusMinutes(Integer.parseInt(data[0][1]));
        data[0][5] = endadd.toString();
        starttime = endadd;
        LocalTime breakadd = starttime.plusMinutes(Integer.parseInt(data[0][2]));
        starttime = breakadd;
        for(int g=1; g<rowcount;)
        {
            data[g][4] = starttime.toString();
            LocalTime endaddtime = starttime.plusMinutes(Integer.parseInt(data[g][1]));
            data[g][5] = endaddtime.toString();
            LocalTime breakaddtime = starttime.plusMinutes(Integer.parseInt(data[g][2]));
            starttime = breakaddtime;
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

    public static void save(String eventtitle,String start,String finish)
    {
        String exporter = "export.csv";
                try 
                {
                    FileWriter fw = new FileWriter(exporter,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    
                    pw.println(eventtitle+","+start+","+finish);
                    pw.flush();
                    pw.close();
                }  catch (IOException p) 
                {
                    p.printStackTrace();
                }
    }
}