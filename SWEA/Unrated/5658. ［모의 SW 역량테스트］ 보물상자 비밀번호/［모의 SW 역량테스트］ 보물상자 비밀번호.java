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
 static int N, K;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            String str = br.readLine().trim();
            arr = str.toCharArray();

            int len = N / 4;
            TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

            for (int rot = 0; rot < len; rot++) {
                for (int i = 0; i < N; i += len) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < len; j++) {
                        sb.append(arr[(i + j) % N]);
                    }
                    int val = Integer.parseInt(sb.toString(), 16);
                    set.add(val);
                }
            
                char last = arr[N - 1];
                for (int i = N - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = last;
            }

            int answer = 0;
            int cnt = 0;
            for (int val : set) {
                cnt++;
                if (cnt == K) {
                    answer = val;
                    break;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}