package baekjoon.no9733;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        String[] jobs = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

        for (String job : jobs) {
            map.put(job, 0);
        }

        int total = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty())
                break;

            String[] works = line.split(" ");

            for (String work : works) {
                map.put(work, map.getOrDefault(work , 0) + 1);
                total++;
            }
        }

        for (String job : jobs) {
            int count = map.get(job);
            double ratio = (double) count / total;

            System.out.printf("%s %d %.2f\n", job, count, ratio);
        }

        System.out.println("Total" + " " + total + " 1.00");
    }
}
