package zad1;

import javax.swing.AbstractListModel;

public class LangMod extends AbstractListModel{

	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getElementAt(int i) {
		switch(i) {
		case 0: return "Polski";
		case 1: return "English";
		case 2:return "Deutsh";
		 
		}
		
	return null;
	}

	
}
