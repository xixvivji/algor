import java.io.*;
import java.util.*;

public class Main {

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        HashSet<String> set = new HashSet<>();
	        
	        String s = br.readLine(); 
	        
	        for(int i = 0; i< s.length(); i++) {
	        	String name = "";
	        	for(int j = i; j <s.length(); j++) {
	        		name += s.substring(j, j+1);
	        		set.add(name);	        	
	        		}
	        }
	        System.out.println(set.size());
	    }
	}