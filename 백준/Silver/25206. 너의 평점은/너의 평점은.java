import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
            double totalGrades = 0.0; 
            double totalCredits = 0.0; 

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 20; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                double credit = Double.parseDouble(st.nextToken());
                String grade = st.nextToken(); 

                if (grade.equals("P")) continue; 

                double point = getGradePoint(grade);
                totalGrades += credit * point;
                totalCredits += credit;
            }

            System.out.println(totalGrades / totalCredits);
        }

        public static double getGradePoint (String grade){
            switch (grade) {
                case "A+":
                    return 4.5;
                case "A0":
                    return 4.0;
                case "B+":
                    return 3.5;
                case "B0":
                    return 3.0;
                case "C+":
                    return 2.5;
                case "C0":
                    return 2.0;
                case "D+":
                    return 1.5;
                case "D0":
                    return 1.0;
                default:
                    return 0.0;
            }
        }
    
}