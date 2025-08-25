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


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int H, W;
    static char[][] map;
    static int tankX, tankY; // 탱크의 현재 위치
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    // 탱크 위치 및 방향 초기화
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' ||
                            map[i][j] == '>') {
                        tankX = i;
                        tankY = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (char cmd : commands.toCharArray()) {
                execute(cmd);
            }


            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void execute(char cmd) {
        switch (cmd) {
            case 'U':
                map[tankX][tankY] = '^';
                move(tankX - 1, tankY);
                break;
            case 'D':
                map[tankX][tankY] = 'v';
                move(tankX + 1, tankY);
                break;
            case 'L':
                map[tankX][tankY] = '<';
                move(tankX, tankY - 1);
                break;
            case 'R':
                map[tankX][tankY] = '>';
                move(tankX, tankY + 1);
                break;
            case 'S':
                shoot();
                break;
        }
    }

    public static void move(int nextX, int nextY) {
        if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && map[nextX][nextY] == '.') {

            char direction = map[tankX][tankY];

            map[tankX][tankY] = '.';

            tankX = nextX;
            tankY = nextY;

            map[tankX][tankY] = direction;
        }
    }

    public static void shoot() {
        char direction = getTankDirection();
        int sx = tankX;
        int sy = tankY;

        while (true) {
            if (direction == '^') {
                sx--;
            } else if (direction == 'v') {
                sx++;
            } else if (direction == '<') {
                sy--;
            } else if (direction == '>') {
                sy++;
            }

            if (sx < 0 || sx >= H || sy < 0 || sy >= W) {
                break;
            }

            if (map[sx][sy] == '*') {
                map[sx][sy] = '.';
                break;
            }

            if (map[sx][sy] == '#') {
                break;
            }
        }
    }

    public static char getTankDirection() {
        return map[tankX][tankY];
    }
}