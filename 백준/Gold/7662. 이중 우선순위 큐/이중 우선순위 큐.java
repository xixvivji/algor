import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    minQ.add(num);
                    maxQ.add(num);
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                } else if (cmd.equals("D")) {
                    if (countMap.isEmpty()) continue;

                    if (num == 1) {
                       
                        while (!maxQ.isEmpty()) {
                            int max = maxQ.poll();
                            if (countMap.getOrDefault(max, 0) > 0) {
                                countMap.put(max, countMap.get(max) - 1);
                                if (countMap.get(max) == 0) countMap.remove(max);
                                break;
                            }
                        }
                    } else {
                    
                        while (!minQ.isEmpty()) {
                            int min = minQ.poll();
                            if (countMap.getOrDefault(min, 0) > 0) {
                                countMap.put(min, countMap.get(min) - 1);
                                if (countMap.get(min) == 0) countMap.remove(min);
                                break;
                            }
                        }
                    }
                }
            }

            Integer min = null, max = null;
            while (!minQ.isEmpty()) {
                int val = minQ.poll();
                if (countMap.getOrDefault(val, 0) > 0) {
                    min = val;
                    break;
                }
            }
            while (!maxQ.isEmpty()) {
                int val = maxQ.poll();
                if (countMap.getOrDefault(val, 0) > 0) {
                    max = val;
                    break;
                }
            }
            if (min == null || max == null) {
                System.out.println("EMPTY");
            } else {
                System.out.println(max + " " + min);
            }
        }
    }
}