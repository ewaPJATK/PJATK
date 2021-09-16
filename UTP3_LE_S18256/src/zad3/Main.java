/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad3;



public class Main {

  public static void main(String[] args) {
	
	  Runnable ss = new SimpleSynchro();
		Thread t1 = new Thread(ss,"watek 1");
		
		Thread t2 = new Thread(ss,"watek2");
		
		Runnable rw = new RWLocks();
		 
		Thread t3 = new Thread(rw, "watek 1");
		Thread t4 = new Thread(rw,"watek 2");
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

  }

}
