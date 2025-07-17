import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열
        int R = sc.nextInt(); // 회전
        int lineRotate = Math.min(M, N) / 2; // 몇개 사각형을 회전 시킬지
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) { // 배열 생성
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        } // 배열 생성 끝

        rotateMatrix(arr, R, lineRotate); //회전시키기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(arr));
    }

    public static void rotateMatrix(int[][] arr, int R, int lineRotate) {
        int N = arr.length;
        int M = arr[0].length;

        for (int r = 0; r < R; r++) {  // R번 회전 시작
            for (int layer = 0; layer < lineRotate; layer++) {
                int temp = arr[layer][layer]; // 회전 전 모서리값 저장

                for (int j = layer; j < M - 1 - layer; j++) {
                    arr[layer][j] = arr[layer][j + 1];
                }

                for (int i = layer; i < N - 1 - layer; i++) {
                    arr[i][M - 1 - layer] = arr[i + 1][M - 1 - layer];
                }

                for (int j = M - 1 - layer; j > layer; j--) {
                    arr[N - 1 - layer][j] = arr[N - 1 - layer][j - 1];
                }

                for (int i = N - 1 - layer; i > layer; i--) {
                    arr[i][layer] = arr[i - 1][layer];
                }

                arr[layer + 1][layer] = temp;
            }
        } // R번 회전 끝


    } // rotate메서드 끝
}