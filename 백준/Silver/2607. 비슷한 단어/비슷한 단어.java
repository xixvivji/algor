import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s= br.readLine();

        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'A']++;

        int answer = 0;
        for (int i = 1; i < N; i++) {
            String w = br.readLine();
            int[] freq = new int[26];
            for (char c : w.toCharArray()) {
            	freq[c - 'A']++;
            }

            int lenS = s.length();
            int lenW = w.length();
            if (Math.abs(lenS - lenW) >= 2) continue; 
            int diff = 0;
            for (int j = 0; j < 26; j++) {
            	diff += Math.abs(arr[j] - freq[j]);
            }
            
            if (lenS == lenW) {
                if (diff == 0 || diff == 2) answer++;
            } else {
                if (diff == 1) answer++;
            }
        }

        System.out.println(answer);
    }
}