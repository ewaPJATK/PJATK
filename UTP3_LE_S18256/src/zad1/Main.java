/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad1;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
	  
 SwingUtilities.invokeLater(new Runnable() {
		 public void run() {
		 new Lista();
		 }
	 });
	  
	 
  }
}
