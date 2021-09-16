/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad2;


public class Main {

  public static void main(String[] args) {
	  
	  Server s = new Server(123);
	  
	    Klient w = new Klient();

		

		

		new Thread(s).start();

		

		System.out.println("Serwer ruszył");

		try{	
			new Thread(w).start();

			Thread.sleep(1000);

		} catch (InterruptedException e)

		{

			e.printStackTrace();

		}

		System.out.println("Serwer zatrzymany");

		s.stop();
  }
}
