package zad1;

import java.util.Timer;

public class Task extends Thread{
	
	
private int number;



public Task() {
	number = 0;
}

public void run() {
	while(this.number<10000) {
		try {
			
			sleep(1000);
			this.number++;
	}catch(InterruptedException e) {}}
		
		
	}

public Integer getNumber() {
	 return this.number;
}
public void end() {
	this.number=10000;
}
public String toString() {
	return String.valueOf(number);
}
}



