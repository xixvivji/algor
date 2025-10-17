
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] nums = s.replace("10", "a").split("");
        int a = 0;
        int b = 0;
        for (String num : nums) {
            if (num.equals("a")) {
                if (a == 0) {
                    a = 10;
                } else {
                    b = 10;
                }
            } else {
                int n = Integer.parseInt(num);
                if (a == 0) {
                    a = n;
                } else {
                    b = n;
                }
            }
        }
        System.out.println(a + b);
    }
}