/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Writer implements Runnable {

	Author autor;

	String[] str = {"Pies", "Kot", "Zebra", "Lew", "Owca", "Słoń"};

	private BlockingQueue<String> bq = new ArrayBlockingQueue<String>(7);

	public Writer(Author autor){

		this.autor = autor;

	}

	@Override
public void run(){

		try{

			write();

		} catch (InterruptedException e){

			e.printStackTrace();

		}

	}

	public void write() throws InterruptedException{	

		for (int i = 0; i < str.length; i++)

		{

			Thread.sleep(1000);

			try{

				bq.put(str[i]);

				System.out.println("--->> "+bq.take());

			} catch (InterruptedException ex){

				ex.toString();

			}}

	}



	

}

