
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            double dist = Math.sqrt(dx * dx + dy * dy);

            if (dist == 0 && r1 == r2) {
                System.out.println(-1);
            } else if (dist > r1 + r2 || dist < Math.abs(r1 - r2)) {
                System.out.println(0);
            } else if (dist == r1 + r2 || dist == Math.abs(r1 - r2)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}