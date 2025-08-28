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
    static double E;
    static int[][] map;
    static boolean[] visited;
    static double[] minEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine().trim());

            visited = new boolean[N];
            minEdge = new double[N];

            Arrays.fill(minEdge, Double.MAX_VALUE);

            minEdge[0] = 0;

            double result = 0;

            for (int i = 0; i < N; i++) {
                double min = Double.MAX_VALUE;
                int minIdx = -1;

                for (int j = 0; j < N; j++) {
                    if (!visited[j] && minEdge[j] < min) {
                        min = minEdge[j];
                        minIdx = j;
                    }
                }

                visited[minIdx] = true;
                result += min;

                for (int j = 0; j < N; j++) {
                    if (!visited[j]) {
                        double dist = getDist(minIdx, j);
                        if (minEdge[j] > dist) {
                            minEdge[j] = dist;
                        }
                    }
                }

            }

            System.out.println("#" + tc + " " + Math.round(result * E));
        }
    }

    static double getDist(int a, int b) {
        long dx = map[a][0] - map[b][0];
        long dy = map[a][1] - map[b][1];
        return dx * dx + dy * dy;
    }
}