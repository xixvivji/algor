import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] picture;
	static boolean[][] visit;
	static int count;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
    static int sum =0;
    static int max =0;
	static void dfs(int x, int y) {
		visit[x][y] = true;
        
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
				if (!visit[cx][cy] && picture[cx][cy] == 1) {
					dfs(cx, cy);
                    sum++;
				}
			}
            

		}
        max = Math.max(sum, max);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

			picture = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
                st =new StringTokenizer(br.readLine());
                for(int j = 0; j< M; j++){
                    picture[i][j] = Integer.valueOf(st.nextToken());
                }

            }



			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (picture[x][y] == 1 && !visit[x][y]) {
						sum = 1;
                        dfs(x, y);
                        max = Math.max(max, sum);
						count++;
					}
				}
			}

			System.out.println(count);
            System.out.println(max);

	}

}