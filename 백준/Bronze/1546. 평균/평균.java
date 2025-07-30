import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] scores = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
            if (scores[i] > max) max = scores[i];
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (scores[i] / max) * 100;
        }

        double avg = sum / N;
        System.out.println(avg);
    }
}