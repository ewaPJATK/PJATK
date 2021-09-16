/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad2;

import java.beans.*;
import java.io.Serializable;

public class Purchase implements Serializable{
	
	
	
	private String prod;
	private String data;
	private double price;
	
	public Purchase() {}
	
	public Purchase(String prod, String data, double price) {
		this.prod=prod;
		this.data=data;
		this.price=price;
		
	}
	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	private VetoableChangeSupport vcs = new VetoableChangeSupport(this);
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(l);
	}
	
	public synchronized void addVetoableChangeListener(VetoableChangeListener vcl) {
		vcs.addVetoableChangeListener(vcl);
	}
	
	
	
	public String getProd() {
		return prod;
	}
	public String getData() {
		return data;
	}
	public double getPrice() {
		return price;
	}
	
	public void setProd(String prod) {
		this.prod = prod;
	}
	public void setData(String newData) {
		String old = data;
		this.data = newData;
		pcs.firePropertyChange("data", old, newData);
	}
	public void setPrice(Double newPrice) throws PropertyVetoException  {
		Double oldPrice = price;
		
		vcs.fireVetoableChange("price", oldPrice, newPrice);
		
		       this.price = newPrice;
		       pcs.firePropertyChange("price", oldPrice, newPrice);
		    
					
				
		 
		   }
	
		   
	
	public String toString() {
		return "Purchase [prod="+prod+", data="+ data +", price=" +price+ "]";
	}
	
}  
