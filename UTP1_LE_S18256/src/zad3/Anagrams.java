/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
	
	List<String> words;
	
	public Anagrams(String w) {
		File txt = new File(w);
		Scanner s;
		words = new ArrayList<>();
		try {
			s=new Scanner(txt);
			while(s.hasNext())words.add(s.next());
			s.close();
		}catch (FileNotFoundException e) {
			System.out.print("blad przy wczytywaniu pliku");
			e.printStackTrace();
		}
		
		
	}
	
	public List<List<String>> getSortedByAnQty(){
		List<List<String>> l1 = new ArrayList<>();
		List<String> wordCopy= new ArrayList<>();
		List<String> checker = new ArrayList<>();
		List<String> store = new ArrayList<>();
		wordCopy.addAll(words);	
		checker.addAll(words);
		
		if(words.size()>2) {
			
			for(Iterator<String>iter=wordCopy.iterator(); iter.hasNext();) {
				boolean found = false;
				String str = iter.next();
				for(Iterator<String> iter2=checker.iterator();iter2.hasNext();) {
					String str2=iter2.next();
					if(Anagrams.test(str, str2)) {
						store.add(str2);
						iter2.remove();
						found = true;
					}
				}
				
				if(!found)continue;
				List<String> tmp = new ArrayList<>();
				tmp.addAll(store);
				l1.add(tmp);
				store.clear();
			}
		}
		l1.sort((e1,e2)->e2.size()-e1.size());
		return l1;
		}
	
	
	
	public static boolean test(String a, String b) {
		char[] w1=a.toCharArray();
		char[] w2=b.toCharArray();
		Arrays.sort(w1);
		Arrays.sort(w2);
		return Arrays.equals(w1, w2);
		
	}
	
	
	
	public String getAnagramsFor(String f) {
		if(!words.contains(f))return f+": null";
		
		List<String>found= new ArrayList<>();
		for(String m: words) {
			if(Anagrams.test(f, m))found.add(m);
		}
	found.remove(f);
	return f+": "+found;
	}
	
	
	
	
	
	
	
}  
