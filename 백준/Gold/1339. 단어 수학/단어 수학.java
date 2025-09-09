
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] srr = new String[N];
        int value[] = new int[26];
        Integer[] order = new Integer[26];
        
        for(int i = 0 ; i < order.length;i++) {
        	order[i] = i;
        }
        
        for(int i = 0 ; i < N; i++) {
        	srr[i] = br.readLine();	
        }
        
        for(String s : srr) {
        	int len =s.length();
        	for(int i =0 ; i <len; i++) {
        		char c = s.charAt(i);
        		value[c-'A'] += (int) Math.pow(10, len -i -1);
        	}
        }
        
        Arrays.sort(order,(a,b) -> value[b] - value[a]);
        int num = 9;
        int [] alpa = new int [26];
        Arrays.fill(alpa, -1);
        
        for(int i = 0 ; i < 26; i++ ) {
        	if(value[order[i]] == 0)break;
        	alpa[order[i]] = num--;
        }
        int res = 0;
        for(String s : srr) {
        	int val = 0;
        	for(int i = 0; i < s.length(); i++) {
        		val = val * 10 + alpa[s.charAt(i) -'A'];
        		
        	}
        	res+= val;
        }
        System.out.println(res);
    }
}