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
	 static int N, M, C;
    static int[][] arr; 
    static int[][] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            max = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    max[i][j] = getMaxProfit(i, j, 0, 0, 0);
                }
            }

            int answer = 0;
            for (int i1 = 0; i1 < N; i1++) {
                for (int j1 = 0; j1 <= N - M; j1++) {
                    for (int i2 = i1; i2 < N; i2++) {
                        int startJ = (i1 == i2) ? j1 + M : 0;
                        for (int j2 = startJ; j2 <= N - M; j2++) {
                            answer = Math.max(answer, max[i1][j1] + max[i2][j2]);
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    static int getMaxProfit(int x, int y, int idx, int sum, int total) {
        if (sum > C) 
            return 0;
        if (idx == M)
            return total;
        int pick = getMaxProfit(x, y, idx + 1, sum + arr[x][y + idx], total + arr[x][y + idx] * arr[x][y + idx]);
        int skip = getMaxProfit(x, y, idx + 1, sum, total);
        return Math.max(pick, skip);
    }
}