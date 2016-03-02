import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by inf.tomatisl2304 on 01/03/2016.
 */
class MyTable extends JTable {
    public MyTable() { }

    public void clear() {
        DefaultTableModel model = new DefaultTableModel();
        this.setModel(model);
        model.fireTableStructureChanged();
    }

    public void addColumns(String[] columns){
        for (int i=0;i<columns.length;i++)
            addColumn(columns[i]);
    }

    public void addColumn(String column){
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.addColumn(column);
    }

    public void addRow(String[] row) {
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.addRow(row);
        model.fireTableStructureChanged();
    }
}

