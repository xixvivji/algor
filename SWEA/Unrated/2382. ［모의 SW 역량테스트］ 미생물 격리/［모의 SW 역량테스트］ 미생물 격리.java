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
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
  static int N, M, K;

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static ArrayList<node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                list.add(new node(x, y, num, dir));
            }

            for (int depth = 0; depth < M; depth++) {
                dfs();
                merge();
            }
            int sum = 0;
            for (node n : list) {
                sum += n.num;
            }
            System.out.println("#" + testCase + " " + sum);

        }


    }

    static void dfs() {
        for (node n : list) {
            n.x = n.x + dx[n.dir];
            n.y = n.y + dy[n.dir];
            if (n.x == 0 || n.x == N - 1 || n.y == 0 || n.y == N - 1) {
                n.num = n.num / 2;
                if (n.dir == 1) {
                    n.dir = 2;
                } else if (n.dir == 2) {
                    n.dir = 1;
                } else if (n.dir == 3) {
                    n.dir = 4;
                } else if (n.dir == 4) {
                    n.dir = 3;
                }
            }
        }
        list.removeIf(n -> n.num == 0);
    }

    static void merge() {
        for (int i = 0; i < list.size(); i++) {
            node n = list.get(i);
            if (n.num == 0) continue;
            int sum = n.num;
            int maxNum = n.num;
            int maxDir = n.dir;
            for (int j = i + 1; j < list.size(); j++) {
                node m = list.get(j);
                if (m.num == 0) continue;
                if (n.x == m.x && n.y == m.y) {
                    sum += m.num;
                    if (m.num > maxNum) {
                        maxNum = m.num;
                        maxDir = m.dir;
                    }
                    m.num = 0;
                }
            }
            n.num = sum;
            n.dir = maxDir;
        }
        list.removeIf(n -> n.num == 0);
    }

    static class node {
        int x;
        int y;
        int num;
        int dir;

        public node(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }

}