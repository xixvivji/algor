import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int x = reverse(nums[0]);
        int y = reverse(nums[1]);
        int sum = x + y;
        System.out.println(reverse(Integer.toString(sum)));
    }

    static int reverse(String s) {
        return Integer.parseInt(new StringBuilder(s).reverse().toString());
    }
}