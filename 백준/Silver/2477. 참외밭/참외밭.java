
import java.io.*;
import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K = Integer.parseInt(br.readLine());
            int[] dir = new int[6];
            int[] len = new int[6];

            for (int i = 0; i < 6; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                dir[i] = Integer.parseInt(st.nextToken());
                len[i] = Integer.parseInt(st.nextToken());
            }

            int maxWidth = 0, maxHeight = 0;
            int idxW = 0, idxH = 0;
            for (int i = 0; i < 6; i++) {
                if (dir[i] == 1 || dir[i] == 2) { 
                    if (len[i] > maxWidth) {
                        maxWidth = len[i];
                        idxW = i;
                    }
                } else {
                    if (len[i] > maxHeight) {
                        maxHeight = len[i];
                        idxH = i;
                    }
                }
            }

            int smallW = Math.abs(len[(idxW+5)%6] - len[(idxW+1)%6]);
            int smallH = Math.abs(len[(idxH+5)%6] - len[(idxH+1)%6]);

            int area = (maxWidth * maxHeight) - (smallW * smallH);
            System.out.println(area * K);
        }
    }