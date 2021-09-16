package zad2;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.concurrent.*;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;



public class Server implements Future<Object> ,Runnable{

	boolean czyZatrzymany = false;

	ServerSocket socket = null;

	Thread thread = null;

	 int port;





	public Server(int port){
     this.port = port;}



	public void run(){

		synchronized (this){
         this.thread = Thread.currentThread();
	}

		openServerSocket();
        while (!czyZatrzymany()){

			Socket cSocket = null;

			try{

				cSocket = this.socket.accept();

			} catch (IOException ev){

				if (czyZatrzymany()==true){

					System.out.println("Serwer został zatrzymany.");
                     return;

				}

				throw new RuntimeException("RuntimeException. Wystąpił problem z połączeniem",

						ev);}

			new Thread(new Klient(cSocket, "Serwer")).start();
		}

		System.out.println("Serwer został zatrzymany.");

	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning)	{

		return false;
	}



	@Override
	public Object get() throws InterruptedException, ExecutionException{

		return null;
}



	@Override
    public Object get(long timeout, TimeUnit unit)

			throws InterruptedException, ExecutionException, TimeoutException

	{
		return null;
}



	@Override
public boolean isCancelled(){
return false;

	}



	@Override
    public boolean isDone(){

		return true;
}

	synchronized boolean czyZatrzymany(){

		return this.czyZatrzymany;

	}



	synchronized void stop(){

		this.czyZatrzymany = true;

		try{

			this.socket.close();

		} catch (IOException e){
       throw new RuntimeException("Wystąpił błąd", e);

		}

	}



	void openServerSocket()

	{

		try{

			this.socket = new ServerSocket(this.port);

		} catch (IOException e)

		{

			throw new RuntimeException("Cannot open port"+this.port, e);

		}

	}



	
}