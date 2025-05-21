import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution { // 자바 함수사용
    public String solution(int a, int b) {

        LocalDate date = LocalDate.of(2016, a, b);


        return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
    }
}

/*
자바함수 사용X
class Solution {
    public String solution(int a, int b) {
        // 요일 배열 (일요일부터 토요일까지)
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        // 각 월의 일수
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 총 날짜 수 계산 (1월 1일부터 (a월 b일)까지 며칠 지났는지)
        int totalDays = 0;
        for (int i = 0; i < a - 1; i++) {
            totalDays += monthDays[i];
        }
        totalDays += (b - 1); // 현재 달의 날도 더하기

        // 요일 계산
        return days[totalDays % 7];
    }
}

 */