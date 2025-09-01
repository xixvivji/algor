import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        int T = Integer.parseInt(br.readLine());

	        for (int tc = 1; tc <= T; tc++) {
	            Deque<Integer> q = new ArrayDeque<>();
	            String op = br.readLine();
	            N = Integer.parseInt(br.readLine()); 

	            
	            String arrLine = br.readLine();
	            arrLine = arrLine.substring(1, arrLine.length() - 1); 
	            if (arrLine.length() > 0) {
	                st = new StringTokenizer(arrLine, ",");
	                while(st.hasMoreTokens()) {
	                    q.addLast(Integer.parseInt(st.nextToken()));
	                }
	            }

	            boolean error = false;
	            boolean reversed = false;

	            for (char c : op.toCharArray()) {
	                if (c == 'R') {
	                    reversed = !reversed; // 방향 전환
	                } else if (c == 'D') {
	                    if (q.isEmpty()) {
	                        error = true;
	                        break;
	                    }
	                    if (!reversed) {
	                        q.pollFirst();
	                    } else {
	                        q.pollLast();
	                    }
	                }
	            }

	            if (error) {
	                System.out.println("error");
	            } else {
	                StringBuilder sb = new StringBuilder();
	                sb.append("[");
	                if (!q.isEmpty()) {
	                    if (!reversed) {
	                        while (!q.isEmpty()) {
	                            sb.append(q.pollFirst());
	                            if (!q.isEmpty()) sb.append(",");
	                        }
	                    } else {
	                        while (!q.isEmpty()) {
	                            sb.append(q.pollLast());
	                            if (!q.isEmpty()) sb.append(",");
	                        }
	                    }
	                }
	                sb.append("]");
	                System.out.println(sb.toString());
	            }
	        }
	    }
	}
