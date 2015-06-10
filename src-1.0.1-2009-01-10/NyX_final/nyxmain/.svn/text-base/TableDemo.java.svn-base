package nyxmain;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.*;
import javax.swing.table.TableModel;
//import java.awt.GridLayout;
import java.awt.Dimension;
import java.io.File;


public class TableDemo extends JPanel implements TableModelListener  { 
    
	private JTable table;
	
	//Boolean[] cb=new Boolean[100];
    
    File folder=new File("/home/pramod/rules");
    File[] listOfFiles=folder.listFiles();
    
    
    
    public MyTableModel tm=new MyTableModel();

    public TableDemo() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        table = new JTable(tm);
        table.setPreferredScrollableViewportSize(new Dimension(500, 170));
        table.setFillsViewportHeight(true);
        
        table.getModel().addTableModelListener(this);
        
        add(new JScrollPane(table));
        
        //for(int i=0;i<100;i++){
        	
        //	cb[i]=new Boolean(false);
        //}
        
    }
    
    //void setBoolean(int row,Boolean c){
    	
    //	cb[row]=c;
    //}
    
    

    
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        
        System.out.println(row+"/"+column);
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        tm.data[row][column]=data;
        System.out.println(tm.data[row][column]+"and"+tm.getValueAt(row, column));
        //repaint();
        
        
        
    }
    
    

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Rules",
                                        "Needed?",};
        /*
        private Object[][] data = {
            {"backdoor.rules",  new Boolean(false)},
            {"ftp", new Boolean(true)},
            {"games",  new Boolean(false)},
            {"x.rules", new Boolean(true)},
            {"dos.rules", new Boolean(false)},
        };*/
        
        private Object[][] data;
        
        public MyTableModel(){
        	
        	int row=listOfFiles.length;
        	data=new Object[row][2];
        	for(int i=0;i<row;i++){
        	
        		data[i][1]=new Boolean(false);
        		//data[i][1]=cb[i]=new Boolean(false);
        		data[i][0]=listOfFiles[i].getName();
        	}
        	
        }
        
        public void setValue(int row,Boolean sd){
        	
        	data[row][1]=sd;
        	
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col ==0) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);
                        
        }
        
    }

    
    
}

