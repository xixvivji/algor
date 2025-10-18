
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //펼쳐서 계산하기?
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int perimeter = 2 * (w + h);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int pos = 0;
            if (dir == 1) pos = dist;
            else if (dir == 2) pos = w + h + (w - dist);
            else if (dir == 3) pos = w + h + w + (h - dist);
            else pos = w + dist;
            arr[i] = pos;
        }

        st = new StringTokenizer(br.readLine());
        int guardDir = Integer.parseInt(st.nextToken());
        int guardDist = Integer.parseInt(st.nextToken());
        int guardPos = 0;
        if (guardDir == 1) guardPos = guardDist;
        else if (guardDir == 2) guardPos = w + h + (w - guardDist);
        else if (guardDir == 3) guardPos = w + h + w + (h - guardDist);
        else guardPos = w + guardDist;

        int sum = 0;
        for (int s : arr) {
            int d = Math.abs(guardPos - s);
            sum += Math.min(d, perimeter - d);
        }
        System.out.println(sum);
    }
}