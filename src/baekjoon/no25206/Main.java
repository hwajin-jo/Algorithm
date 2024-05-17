package baekjoon.no25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 20;

        int totalCredit = 0;
        double totalScore = 0;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            switch (grade) {
                case "A+":
                    totalScore += 4.5 * credit;
                    totalCredit += credit;
                    break;
                case "A0":
                    totalScore += 4.0 * credit;
                    totalCredit += credit;
                    break;
                case "B+":
                    totalScore += 3.5 * credit;
                    totalCredit += credit;
                    break;
                case "B0":
                    totalScore += 3.0 * credit;
                    totalCredit += credit;
                    break;
                case "C+":
                    totalScore += 2.5 * credit;
                    totalCredit += credit;
                    break;
                case "C0":
                    totalScore += 2.0 * credit;
                    totalCredit += credit;
                    break;
                case "D+":
                    totalScore += 1.5 * credit;
                    totalCredit += credit;
                    break;
                case "D0":
                    totalScore += credit;
                    totalCredit += credit;
                    break;
                case "F":
                    totalScore += 0.0 * credit;
                    totalCredit += credit;
                    break;
                case "P":
                    continue;
                default:
            }
        }

        System.out.printf("%.6f", totalScore / totalCredit);
    }
}
