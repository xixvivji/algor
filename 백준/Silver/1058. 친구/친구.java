import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] dist;
    static final int INF = 9999999; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char relation = line.charAt(j);
                if (i == j) {
                    dist[i][j] = 0;
                } else if (relation == 'Y') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < N; k++) { 
            for (int i = 0; i < N; i++) { 
                for (int j = 0; j < N; j++) { 
                    if (i == j) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int maxFriends = 0;
        for (int i = 0; i < N; i++) {
            int currentFriends = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] <= 2) {
                    currentFriends++;
                }
            }
            maxFriends = Math.max(maxFriends, currentFriends);
        }

        System.out.println(maxFriends);
    }
}