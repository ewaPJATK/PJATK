/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.*;
import java.util.*;

public class Calc
{
     
	HashMap<String,Method> map = new HashMap();
    final MathContext zaokrąglenie = new MathContext(7, RoundingMode.HALF_UP);
    
    public Calc()
    {
    	Class klasa = null;
    	
    	try {
    		klasa = Class.forName("java.math.BigDecimal");
    	} catch (ClassNotFoundException e) {
    		System.out.print("błąd przy inicjalizacji klasy");
    		}
    	
        Class c = BigDecimal.class;
    	
        Method[] metody = new Method[4];
        try {
        	metody[0]= klasa.getMethod("add",c);
            metody[1]=klasa.getMethod("subtract", c);
            metody[2]=klasa.getMethod("divide", c);
    	   metody[3]=klasa.getMethod("multiply", c);}
        catch (NoSuchMethodException | SecurityException e){
        	System.out.print("błąd przy inicjalizacji elemetów tablicy metod");
    	}
    	
        String [] operator = {"+","-","/","*"};

        for(int i=0;i<metody.length;i++) {

    		map.put(operator[i], metody[i]);}
    		
    }
  
	public String doCalc(String str) {
    	
    	String[] items = str.split("\\s+");
        BigDecimal uno = null;
        BigDecimal secundo = null;
        Method op = null;
      
	BigDecimal operation = new BigDecimal(0).round(zaokrąglenie);
			//).setScale(7, RoundingMode.HALF_UP);
      //  BigDecimal temp= null;
        
     
            uno = new BigDecimal(items[0]);//setScale(7, RoundingMode.HALF_UP);
            op = map.get(items[1]);
            secundo = new BigDecimal(items[2]);//setScale(7,RoundingMode.HALF_UP);
            
            try {
            	
				operation = ((BigDecimal) op.invoke(uno,secundo)).round(zaokrąglenie);
				
            	str=operation.toString();
				return str;
				
			} catch (IllegalArgumentException | InvocationTargetException  | IllegalAccessException ile) {
			
				//ile.printStackTrace();
				return "invalid command to calc";
			}
           // ;
    }
}

