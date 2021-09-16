package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class DataChange implements PropertyChangeListener,VetoableChangeListener{

	public DataChange(){}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		
		if(evt.getPropertyName().equals("price"))
			System.out.println("Change value of: "+evt.getPropertyName()+" from: "+evt.getOldValue()+" to: "+evt.getNewValue());
		
		else if(evt.getPropertyName().equals("data"))
		System.out.println("Change value of: "+evt.getPropertyName()+" from: "+evt.getOldValue()+" to: "+evt.getNewValue());
	
	}
	private static int limit=1000;
	
	
	
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		Double	newVal = (Double)evt.getNewValue();
		
		if(newVal<=limit) throw new PropertyVetoException("Price change to: "+newVal+" not allowed ",evt);
		
		
	}
	
	}


