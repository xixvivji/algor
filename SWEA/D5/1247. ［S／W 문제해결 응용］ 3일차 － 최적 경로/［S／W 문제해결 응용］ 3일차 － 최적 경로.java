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
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 2][2];
            visited = new boolean[N + 2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N + 2; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);
            System.out.println("#" + testCase + " " + min);
        }// 테케 횟수

    }// main

    static void dfs(int cur, int count, int distance) {
        if (min < distance) {
            return;
        }

        if (count == N) {
            distance += Math.abs(arr[cur][0] - arr[1][0]) +
                    Math.abs(arr[cur][1] - arr[1][1]);
            min = Math.min(min, distance);
            return;
        }
        for (int i = 2; i < N + 2; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int dist = Math.abs(arr[cur][0] - arr[i][0]) + Math.abs(arr[cur][1] - arr[i][1]);
                dfs(i, count + 1, distance + dist);
                visited[i] = false;
            }

        }
    }


}