/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Author extends Thread implements Runnable {

	private BlockingQueue<String> bq = new ArrayBlockingQueue<String>(6);
    String[] str = {"Pies", "Kot", "Zebra", "Lew", "Owca", "Słoń"};



	public Author(String[] args){

		str = args;

	}


			@Override
		public void run(){

				write();
			}
			
			
			
	public void write(){

     for (int i = 0; i <str.length;i++){

			System.out.println(str[i]);

			try{

				bq.put(str[i]);

				System.out.println(bq.take());

			} catch (InterruptedException ex){

				ex.toString();

			}}



	}

	
}  
