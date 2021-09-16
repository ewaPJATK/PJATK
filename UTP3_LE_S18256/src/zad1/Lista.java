package zad1;

import java.awt.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Lista extends JFrame {
	
	Thread t;
	Task task;
	Executor exec;

	String[] status= {"create","run","sleep","interrupt","terminate","stan","wynik"};
	JList list = new JList(status);
	JScrollPane sp = new JScrollPane(list);
	JPanel panelKomunikatu = new JPanel();
	JLabel stanWątku;
	//JLabel wynik;
	
	JPanel panel;
	/*JTextArea txt;
	JTextArea txt2;
	
	/*JButton run;
	JButton interrupt;
	JButton sleep;
	JButton kill;
	JButton checkStatus;*/
	
	
	
	public Lista(){
		
		// = new Task();
		
		stanWątku = new JLabel("stanWątku: ");
		//wynik = new JLabel("wynik: ");
		this.setTitle("Manadżer wątków");
		this.setBounds(600,300, 600, 500);
		
		list.setVisibleRowCount(3);
		list.setFixedCellHeight(30);
		list.setFixedCellWidth(200);
		list.setBackground(Color.LIGHT_GRAY);
		list.setSelectionBackground(Color.CYAN);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {
					String element= (String) ((JList)e.getSource()).getSelectedValue();
					
					if(element.equals("create"))task= new Task();
					stanWątku.setText("Stan wątku: "+String.valueOf(task.getState()));
					
					if(element.equals("run")&& !task.isAlive()) task.start();
					//stanWątku.setText("Zadanie rozpoczęto");
					stanWątku.setText("Stan wątku: "+String.valueOf(task.getState()));
			
					if(element.equals("sleep")&& task.isAlive())try {
						task.sleep(100);
						stanWątku.setText("Stan wątku: "+task.getState().toString());
						//stanWątku.setText("Wątek został uśpiony na ");
					}catch(InterruptedException ie) {
						//stanWątku.setText("Wątek nie został uśpiony, coś poszło nie tak.... ;( ");
						task.end();
					}
					if (element.equals("stan")) 
						stanWątku.setText( task.getState().toString());
					
					if(element.equals("wynik"))stanWątku.setText(String.valueOf(task.getNumber()));
					
					if(element.equals("terminate")) {
						task.end();
					   stanWątku.setText("Stan wątku: "+task.getState().toString());
							
					}
					
					if (element.equals("interrupt")) {task.interrupt();
					stanWątku.setText("Stan wątku: "+String.valueOf(task.getState()));}
				}		
				
				
		}
			});
		
		panel = new JPanel();
		
		panel.add(sp);
		panelKomunikatu.add(stanWątku);
		//panelKomunikatu.add(wynik);
		
		
		
		this.getContentPane().add(panel, BorderLayout.WEST);
		this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		
		
	}
	
		
}
