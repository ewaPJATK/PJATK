package zad2;

import java.io.IOException;

import java.io.PrintWriter;

import java.net.Socket;

import java.net.UnknownHostException;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;



public class Klient implements Future<Object> ,Runnable{ 

	Socket socket = null;

	String text = null;



	public Klient(Socket socket, String text)

	{

		
		this.text = text;
		this.socket = socket;


	}



	public Klient(){}



	public void run(){

		try{
        for (int i = 0; i < 10; i++)	{

				Thread.sleep(1000);
                long czas = System.currentTimeMillis();

				System.out.println("Żądanie przetworzone : " + czas + "\n"
              	+ "proces " + (i + 1));}

		}catch (Exception ex)

		{

			// report exception somewhere.

			ex.printStackTrace();

		}

	}

	@Override
public boolean isCancelled(){return false;}



	@Override
public boolean isDone(){ return false;}

	@Override
    public Object get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException{ return null;}

	@Override
public boolean cancel(boolean arg0){return false;}



	@Override 
	public Object get() throws InterruptedException, ExecutionException {return null;}



	







}
