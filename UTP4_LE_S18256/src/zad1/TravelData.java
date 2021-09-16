package zad1;

import java.io.*;

import java.text.*;

import java.util.*;



public class TravelData {
	
	private String destination;
	private Double price;
	private String currency;
	private static boolean bltr = true;
	

	private ArrayList<String> tlista;
	
	 String offer;
	 ArrayList<ArrayList<Object>> toffers;
	 ArrayList<Object> singleOffer;
	 Locale loc;
	private String country;
	
	
	 Date leaveDate;
	 Date returnDate;
	
	
	
	
	
	static Date transformToDate(String str){
		
		SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getInstance();
		String s = "yyyy-MM-dd";
		sdf.applyPattern(s);
		Date d = null;
		try {
			d = sdf.parse(str);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		return d;
	}

   
	List<String> getOffersDescriptionsList(String local, String dat){
		List<String> result = new ArrayList<String>();
		ArrayList lin = new ArrayList();
		String oneLine ="";
		String [] localTab = null;
		Locale l = null;
		if(local.length()>2){
			localTab = local.split("_");
			l = new Locale(localTab[0], localTab[1]);
		}
		else{
		l = new Locale(local);}
		
		SimpleDateFormat form = (SimpleDateFormat)DateFormat.getDateInstance();
		form.applyPattern(dat);
		
		
		NumberFormat Nf = NumberFormat.getInstance(l);

		for(ArrayList elt : this.toffers){
			lin = elt;
			String cen = Nf.format(lin.get(5));
			ResourceBundle info = ResourceBundle.getBundle("zad1.Info", l);
			String cotr = (String)info.getObject((String) lin.get(1));
			String dest = (String)info.getObject((String)lin.get(4));
			
			oneLine = cotr  +" "+ form.format((Date)lin.get(2)) + " "+ form.format((Date)lin.get(3)) + " "+ dest +" "+ cen+" "+(String) lin.get(6);
					
			result.add(oneLine);
		}
		
		return result;
		
	}
public TravelData(File file){
		
		toffers = new ArrayList<ArrayList<Object>>();
		tlista = new ArrayList<String>();
		
		File [] oferty= file.listFiles();
		
		
		try {
		for(int i=0; i< oferty.length; i++){
			
		
		
			Scanner scan = new Scanner(oferty[i]);
			
			while(scan.hasNextLine()){
				
				bltr = true;
				
				offer = scan.nextLine();
				while(bltr){
				
				String [] s = offer.split("\\t+");
				
				if(s[0].length()>2){
				String [] st = s[0].split("_");
				loc = new Locale(st[0], st[1]);}
				else{
					loc= new Locale(s[0]);
				}
			
			
			scan.useLocale(loc);
				Locale.setDefault(loc);
				if(s.length==7){
				
		        country = s[1];
				leaveDate = transformToDate(s[2]);
				returnDate = transformToDate(s[3]);
				destination = s[4];
				scan = new Scanner(s[5]);
				scan.useLocale(loc);
				price = scan.nextDouble();
				currency = s[6];}
				if(s.length==8){
					country = s[1] + " "+ s[2];
				
				leaveDate = transformToDate(s[3]);
				returnDate = transformToDate(s[4]);
				
				destination = s[5];
				scan = new Scanner(s[6]);
				scan.useLocale(loc);
				price = scan.nextDouble();
				currency = s[7];}
				singleOffer = new ArrayList<Object>();
				singleOffer.add(loc);
				singleOffer.add(country);
				singleOffer.add(leaveDate);
				singleOffer.add(returnDate);
				singleOffer.add(destination);
				singleOffer.add(price);
				singleOffer.add(currency);
				
				toffers.add(singleOffer);
				
				tlista.add(offer);
				bltr = false;
				
				
				}
			
				
			}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}