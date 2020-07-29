package rpultra;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ZoneManagerTableModel extends AbstractTableModel {
    private String[] columnNames = {
            "Name",
            "Icon",
            "Colour",
            "Vertices"
    };
    private ArrayList<Object[]> data = new ArrayList<>();

    public void addRow(Object[] row) {
        if (row.length != columnNames.length) {
            throw new RuntimeException("Number of columns must be equal to " + columnNames.length + "!");
        }

        data.add(row);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Object[] row = data.get(rowIndex);
        row[columnIndex] = value;
        data.set(rowIndex, row);
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return data.get(0)[columnIndex].getClass();
    }
}