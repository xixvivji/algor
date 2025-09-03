/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
 static int N;
    static int[][] arr;
    static int[] dx = {1, 1, -1, -1}; 
    static int[] dy = {1, -1, -1, 1};
    static int answer;
    static int startX, startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            answer = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    startX = i;
                    startY = j;
                    ArrayList<Integer> dessertList = new ArrayList<>();
                    dfs(i, j, 0, -1, dessertList);
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int x, int y, int cnt, int dir, ArrayList<Integer> dessertList) {
        dessertList.add(arr[x][y]);

        for (int d = dir == -1 ? 0 : dir; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx == startX && ny == startY && cnt >= 3) {
                answer = Math.max(answer, cnt + 1);
                continue;
            }
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!dessertList.contains(arr[nx][ny])) {
                    dfs(nx, ny, cnt + 1, d, dessertList);
                }
            }
        }

        dessertList.remove(dessertList.size() - 1); 
    }
}