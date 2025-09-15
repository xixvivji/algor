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

import java.io.*;
import java.util.*;

public class Solution {
	  static int N;
	    static Point[] points;
	    static long min; 
	    static class Point {
	        int x, y;
	        Point(int x, int y) { this.x = x; this.y = y; }
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	        for(int tc =1; tc <=T; tc ++) {
	            N = Integer.parseInt(br.readLine());
	            points = new Point[N];
	            int totalX = 0, totalY = 0;
	            for (int i = 0; i < N; i++) {
	                StringTokenizer st = new StringTokenizer(br.readLine());
	                int x = Integer.parseInt(st.nextToken());
	                int y = Integer.parseInt(st.nextToken());
	                points[i] = new Point(x, y);
	                totalX += x;
	                totalY += y;
	            }
	            min = Long.MAX_VALUE;
	            comb(0, 0, totalX, totalY, 0, 0);
	            System.out.println("#" + tc + " " +min);
	        }
	    }

	    static void comb(int idx, int cnt, int totalX, int totalY, int sx, int sy) {
	        if (cnt == N / 2) {
	            long vx = 2L * sx - totalX;
	            long vy = 2L * sy - totalY;
	            long len2 = vx * vx + vy * vy; 
	            if (len2 < min) min = len2;
	            return;
	        }
	        if (idx == N) return;
	        comb(idx + 1, cnt + 1, totalX, totalY, sx + points[idx].x, sy + points[idx].y);
	        comb(idx + 1, cnt, totalX, totalY, sx, sy);
	    }
	}