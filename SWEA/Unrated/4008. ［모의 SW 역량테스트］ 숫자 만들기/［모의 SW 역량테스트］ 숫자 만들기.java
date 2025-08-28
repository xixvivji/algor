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
	static int T, N;
	static int[] nums;
	static int[] operators = new int [4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	 public static void main(String[] args) throws Exception{

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       T = Integer.parseInt(br.readLine());
       
       for (int tc = 1; tc <= T; tc++) {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		
		st  =new StringTokenizer(br.readLine());
		for(int i = 0; i< 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
			
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
		dfs(nums[0], 1);
		 
	
			 System.out.println("#"+tc + " " + (max - min));
		 
		
		
		
	}// tc
       
   }// main
	 
	 
	 static void dfs(int curVal, int index) {
		 if(index == N) {
			 max = Math.max(max, curVal);
			 min = Math.min(min, curVal);
			 return;
		 }
		 for (int i = 0; i < 4; i++) {
	            if (operators[i] > 0) {
	                operators[i]--;
	                switch (i) {
	                    case 0:
	                        dfs(curVal + nums[index], index + 1);
	                        break;
	                    case 1:
	                        dfs(curVal - nums[index], index + 1);
	                        break;
	                    case 2:
	                        dfs(curVal * nums[index], index + 1);
	                        break;
	                    case 3:
	                        dfs(curVal / nums[index], index + 1);
	                        break;
	                }
	                operators[i]++; 
	            }
	        }
	    }

//	    static int div(int a, int b) {
//	      
//	        if (a < 0) {
//	            return - (Math.abs(a) / b);
//	        } else {
//	            return a / b;
//	        }
//	    }
	}