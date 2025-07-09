import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		
		while((str = br.readLine()) != null) {
			StringTokenizer strtk = new StringTokenizer(str," ");
			int a = Integer.parseInt(strtk.nextToken());
			int b = Integer.parseInt(strtk.nextToken());
			bw.write(a+b+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}