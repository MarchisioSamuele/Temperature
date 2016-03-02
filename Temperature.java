
import javax.swing.*;
import java.awt.*;

/**
 * Created by inf.tomatisl2304 on 01/03/2016.
 */
class Temperature extends JFrame{
    public Temperature(){
        initUI();
    }
    private void initUI(){
        super.setTitle("temperature");
        super.setSize(300,600);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel pnlMain = new JPanel();
        JPanel pnlCenter = new JPanel(new GridLayout(2,1));
        pnlMain.setLayout(new BorderLayout());

        JButton btnOpen = new JButton("Open...");
        JPanel pnlNorth = new JPanel();
        pnlNorth.add(btnOpen);
        pnlMain.add(pnlNorth,BorderLayout.NORTH);

        MyTable table = new MyTable();
        JScrollPane pnlScroll = new JScrollPane(table);
        pnlCenter.add(pnlScroll);


        MyJGraph pnlGraph = new MyJGraph(300,600);
        pnlCenter.add(pnlGraph);

        pnlMain.add(pnlCenter);

        this.add(pnlMain);
        btnOpen.addActionListener(new OpenActionListener(table,pnlGraph));

    }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                Temperature frm = new Temperature();
            }
        });
    }
}

