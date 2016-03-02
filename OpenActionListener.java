import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

/**
 * Created by inf.tomatisl2304 on 01/03/2016.
 */

class OpenActionListener implements ActionListener {
    private MyTable tblData;
    private MyJGraph grfData;
    int min, max;

    public OpenActionListener(MyTable tblData, MyJGraph grfData){
        this.tblData = tblData;
        this.grfData = grfData;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser pnlOpen = new JFileChooser();
        if (pnlOpen.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) return;
        File file = pnlOpen.getSelectedFile();
        Vector<String[]> rows= new Vector <String[]> ();
        tblData.clear();

        try {
            min = max = 0;

            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = input.readLine();

            tblData.addColumns(line.split(";"));
            tblData.addColumn("Range");

            while((line = input.readLine()) != null) {
                String[] fields = createRow(line);
                tblData.addRow(fields);
                rows.add(fields);
            }

            input.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        grfData.draw(min, max, rows);
    }

    private String[] createRow(String line) {
        String[] monthDescr = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Opt","Nov","Dec"};

        String [] fields = line.split(";");
        int localMin = Integer.parseInt(fields[1]);
        int localMax = Integer.parseInt(fields[2]);
        int range = localMax - localMin;

        if (localMin < min) min = localMin;
        if (localMax > max) max = localMax;

        String[] ret = { monthDescr[Integer.parseInt(fields[0])-1],
                "" + localMin ,
                "" + localMax,
                "" + range };
        return ret;
    }
}

