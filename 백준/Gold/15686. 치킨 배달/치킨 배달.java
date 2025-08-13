import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Point> houses;
    static List<Point> chickens;
    static int[][] distances; 
    static int minCityChickenDistance = Integer.MAX_VALUE;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) {
                    houses.add(new Point(r, c));
                } else if (info == 2) {
                    chickens.add(new Point(r, c));
                }
            }
        }

        int houseCount = houses.size();
        int chickenCount = chickens.size();
        distances = new int[houseCount][chickenCount];
        for (int i = 0; i < houseCount; i++) {
            for (int j = 0; j < chickenCount; j++) {
                distances[i][j] = Math.abs(houses.get(i).r - chickens.get(j).r)
                                + Math.abs(houses.get(i).c - chickens.get(j).c);
            }
        }

        int chickenSize = chickens.size();
        for (int mask = 0; mask < (1 << chickenSize); mask++) {
            if (Integer.bitCount(mask) == M) {
                calculateCityDistance(mask);
            }
        }

        System.out.println(minCityChickenDistance);
    }

    public static void calculateCityDistance(int mask) {
        int currentCityDistance = 0;

        for (int i = 0; i < houses.size(); i++) {
            int minDistance = Integer.MAX_VALUE;

            for (int j = 0; j < chickens.size(); j++) {
                if ((mask & (1 << j)) != 0) {
                    minDistance = Math.min(minDistance, distances[i][j]);
                }
            }

            currentCityDistance += minDistance;
            if (currentCityDistance >= minCityChickenDistance) {
                return;
            }
        }

        minCityChickenDistance = Math.min(minCityChickenDistance, currentCityDistance);
    }
}