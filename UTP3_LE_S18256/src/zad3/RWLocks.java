package zad3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLocks implements Runnable{
	
	long start;
	long stop;
	int counter=0;
	String msg[]= {"Czarna ","krowa ","w ","kropki ","bordo ","gryzła ","trawe ","kręcąc "," mordą"};
	//String msg2[]= {"*","*","*","*"};
	
	String txt[]= new String [msg.length];
	
private ReentrantReadWriteLock rwl= new ReentrantReadWriteLock();
	

	private Lock readLock = rwl.readLock();
	private Lock writeLock = rwl.writeLock();
	
	public void run() {
		start = System.currentTimeMillis();
		do{
		
		
		getMsg(Thread.currentThread().getName());
		WriteMsg(Thread.currentThread().getName());
		counter++;
		}while(counter<100);
		stop = System.currentTimeMillis();
		System.out.print("czas wykonania programu RWLocks : " + (stop - start)+"milisekund");
	}

	  void WriteMsg(String threadName) {
		readLock.lock();
		for(int i=0;i<txt.length;i++) {
			System.out.println("RWLocks: "+threadName+": "+txt[i]);
		}try {
			Thread.sleep(1);
				
			}catch(InterruptedException ex) {
				
			}readLock.unlock();
		}
	

	 void getMsg(String threadName) {
		writeLock.lock();
		 for(int i=0;i<msg.length;i++)
			{
			txt[i]=msg[i];
			}try {
				Thread.sleep(1);
			}catch(InterruptedException exc) {
				
			}
		writeLock.unlock();
	}

}
