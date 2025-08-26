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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
 static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1};   // 좌, 우, 상
    static int[] dy = {-1, 1, 0};   // 좌, 우, 상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     for (int testCase = 1; testCase <= 10; testCase++) {
            br.readLine();
            arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = -1;
            for (int i = 0; i < 100; i++) {
                if (arr[99][i] == 2) {
                    int x = 99;
                    int y = i;
                    visited = new boolean[100][100];

                    while (x != 0) {
                        visited[x][y] = true;
                        boolean moved = false;
                        for (int dir = 0; dir < 2; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            while (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 &&
                                   arr[nx][ny] == 1 && !visited[nx][ny]) {
                                x = nx;
                                y = ny;
                                visited[x][y] = true;
                                nx = x + dx[dir];
                                ny = y + dy[dir];
                                moved = true;
                            }
                            if (moved) break; 
                        }
                        if (!moved) {
                            int nx = x + dx[2];
                            int ny = y + dy[2];
                            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                                x = nx;
                                y = ny;
                            }
                        }
                    }
                    answer = y;
                    break;
                }
            }
            System.out.println("#" + testCase + " " + answer);
        }
    }
}