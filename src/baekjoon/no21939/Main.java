package baekjoon.no21939;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Problem> map = new HashMap<>();
        TreeSet<Problem> set = new TreeSet<>();
        while (N-- > 0) {
            String[] data = br.readLine().split(" ");
            int number = Integer.parseInt(data[0]);
            int level = Integer.parseInt(data[1]);

            Problem problem = new Problem(number, level);
            map.put(number, problem);
            set.add(problem);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String[] data = br.readLine().split(" ");
            if (data[0].equals("add")) {
                int number = Integer.parseInt(data[1]);
                int level = Integer.parseInt(data[2]);
                Problem problem = new Problem(number, level);
                map.put(number, problem);
                set.add(problem);
            } else if (data[0].equals("solved")) {
                int number = Integer.parseInt(data[1]);
                Problem problem = map.remove(number);
                set.remove(problem);
            } else {
                if (data[1].equals("1")) {
                    bw.write(set.last().number + "\n");

                } else {
                    bw.write(set.first().number + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

class Problem implements Comparable<Problem> {
    int number;
    int level;

    public Problem(int number, int level) {
        this.number = number;
        this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
        if (this.level == o.level) {
            return this.number - o.number;
        }

        return this.level - o.level;
    }
}