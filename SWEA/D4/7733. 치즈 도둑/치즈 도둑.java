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
 static int T;
    static int N;
    static int [][]arr;
    static int max ;
    static int[]dx = {-1,1,0,0};
    static int[]dy = {0,0,-1,1};
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            int maxCheese = 0;
            int minCheese = 100;

            for (int i = 0; i < N; i++) {
               st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxCheese = Math.max(maxCheese, arr[i][j]);
                    minCheese = Math.min(minCheese, arr[i][j]);
                }
            }

            int answer = 1;
            for (int day = minCheese; day <= maxCheese; day++) {
                visited = new boolean[N][N];
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] > day && !visited[i][j]) {
                            dfs(i, j, day);
                            cnt++;
                        }
                    }
                }
                answer = Math.max(answer, cnt);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
    static void dfs(int x, int y, int day) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && arr[nx][ny] > day) {
                    dfs(nx, ny, day);
                }
            }
        }
    }
}