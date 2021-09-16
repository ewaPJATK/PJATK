package zad1;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel implements TableModelListener{
	
	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override 
	public void setValueAt(Object element,int x, int y) {
		Vector v = Database.content.get(x);
		v.set(y, element);
		Database.content.set(x, v);
		fireTableCellUpdated(x,y);
	}
	

	public Model() {
		addTableModelListener(this);
	}

	@Override 
	public String getColumnName(int x) {
		return (String) Database.columns.get(x);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Database.columns.size();
	}
	@Override 
	public boolean isCellEditable(int x, int y) {
		return false;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Database.content.size()	;
	}

	@Override
	public Object getValueAt(int x, int y) {
		
		Object o = null;
		
		if(y==0)Database.content.get(x).get(0);
		if(y==1)Database.content.get(x).get(1);
		if(y==2)Database.content.get(x).get(2);
		if(y==3)Database.content.get(x).get(3);
		if(y==4)Database.content.get(x).get(4);
		if(y==5)Database.content.get(x).get(5);
		
		return o;
		
	}


	
}
