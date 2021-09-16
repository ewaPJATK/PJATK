package zad1;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;

import java.util.*;



public class Database extends JFrame implements MouseListener,ActionListener {
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	
	public static Vector<Vector> content;
	static Vector columns;
	static Vector lines;
	JTable jt;
	JScrollPane jsp;
	Model model;
	static int offerID =1;
	ArrayList<ArrayList<Object>> offers;
	static String url;
	static JList<String> language;
	static JList<String> location;
	String[] columnNames= {"Country","Leave date","Return date",
			"Destination","Price","Currency"};
	
	
	public Database(String str, TravelData td) {
		url= str;
		offers = td.toffers;
		
		columns = new Vector();
		
		for(int i =0;i<columnNames.length;i++) columns.add(columnNames[i]);
			
		content = new Vector<Vector>();
		
		ArrayList<ArrayList<Object>> list = td.toffers;
		
		for(int i =0;i<list.size();i++) {
			Vector line = new Vector();
			for(int j=1;j<list.get(i).size();j++) {
				line.addElement(list.get(i).get(j));}
			content.addElement(line);
			}
		
		jt = new JTable();
		model = new Model();
		jt.setModel(model);
		
		
	}
	
	
	String trnslt(String str, Locale lcl) {
		
		ResourceBundle info = ResourceBundle.getBundle("zad1.Info",lcl);
		String country = (String)info.getObject(str);
		return country;
	}
	
	void showGui() {
		String [] loc = {"Polska","England","Deutschland"};
		String[] lang = {"Polski","English","Deutsch"};
		
		language = new JList(lang);
		location= new JList(loc);
		jsp = new JScrollPane(this.jt);
		LangMod lm = new LangMod();
		
		location.setModel(lm);
		language.setModel(lm);
		
		
		language.addMouseListener(this);
		location.addMouseListener(this);
		
		JLabel jlang = new JLabel("Laguage options");
		JLabel jloc = new JLabel("Location options");
		
		JSplitPane js3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jlang,language);
		JSplitPane js4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jloc,location);
		
		JSplitPane js2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,js3,js4);
		JSplitPane js1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,js2,jsp);

		Container c = this.getContentPane();
		c.add(js1);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		}
	
	
	public void create() {
		Connection con;
		String surl = this.url;
		Statement stat = null;
		try {
			Class.forName("jdbc:ucanaccess://c:/BDUTP.accdb;newDatabaseVersion=V2765");
			con = DriverManager.getConnection(surl);
			stat = con.createStatement();
		}catch(ClassNotFoundException exc) {
		
				exc.printStackTrace();
				System.out.print(" ");
				System.exit(1);
			}catch(SQLException se) {
				se.printStackTrace();
				System.exit(1);
		}
	
		String sqlCommand = "CREATE TABLE TRAVELS("  
							  + "ID INTEGER , + "
							  + "LOCALE VARCHAR(8)," 
								+ "COUNTRY VARCHAR(50)," 
								+ "LEAVE_DATE DATE," 
								+ "RETURN_DATE DATE," 
								+ "DESTINATION," 
								+ "PRICE DOUBLE," 
								+"CURRENCY VARCHAR(4))" ;
							
		
		try {
			stat.executeUpdate(sqlCommand);
			System.out.print("Table dropped");
		}catch(SQLException se) {
			se.printStackTrace();
		}
	
		
		for(int i =0;i<this.offers.size();i++) {
			String lo = ((Locale) this.offers.get(i).get(0)).toString();
			String coun = (String) this.offers.get(i).get(1);
			String datLeav = this.offers.get(i).get(2).toString();
			String datRet = this.offers.get(i).get(3).toString();
			String des = (String)this.offers.get(i).get(4);
			Double pric = (Double) this.offers.get(i).get(5);
			String cu = (String) this.offers.get(i).get(6);
			offerID++;
			try {
				stat.executeUpdate("INSERT INTO TRAVELS VALUES ( offerId, " + lo +", " + coun + ", " + datLeav+ ", "
						+  datRet + ",  " + des+", " + pric+ ", " + cu +")");
				System.out.println("wstawiono wiersz");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		Object k = me.getSource();
		int n = language.getSelectedIndex();
		int lc = location.getSelectedIndex();
		if(n==0){
			for(int i =0; i<content.size(); i++){
			trnslt((String)content.get(i).get(0), new Locale("pl", "PL"));
			
			}
			TableModelEvent tme = new TableModelEvent(this.model);
			this.model.tableChanged(tme);
		}
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}