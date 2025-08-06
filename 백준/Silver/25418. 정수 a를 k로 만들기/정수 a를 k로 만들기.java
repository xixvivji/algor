import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A,K;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int count=0;
		while(true) {
			if(k==a) {
				break;
			}
			if(k%2==0 &&k/2>=a) {
				k/=2;
			}
			else {
				k-=1;
			}
			count++;
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
	}
}