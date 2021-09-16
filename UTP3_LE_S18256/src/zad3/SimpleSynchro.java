package zad3;



public class SimpleSynchro extends Thread{
	
	long start;
	long stop;
	int counter=0;
	String msg[]= {"Czarna ","krowa ","w ","kropki ","bordo ","gryzła ","trawe ","kręcąc "," mordą"};
	String txt[] = new String[msg.length];
	public SimpleSynchro(){};
	
	
		public void run() {
			
			start = System.currentTimeMillis();
			
			do{
				
			
			getMsg(Thread.currentThread().getName());
			WriteMsg(Thread.currentThread().getName());
			counter++;
			}while(counter<100);
			
			stop = System.currentTimeMillis();
			System.out.print("czas wykonania programu SimpleSynchro : " + (stop - start)+"milisekund");
		}
		
	

	 synchronized void WriteMsg(String threadName) {
			
			for(int i=0;i<txt.length;i++) {
				System.out.println("Simple Synchro: "+threadName+": "+txt[i]);
			}try {
				Thread.sleep(1);
					
				}catch(InterruptedException ex) {
					
				}
			}
		

	synchronized void getMsg(String threadName) {
		
			 for(int i=0;i<msg.length;i++)
				{
				txt[i]=msg[i];
				}try {
					Thread.sleep(1);
				}catch(InterruptedException exc) {
					
				}
			
		}

}

