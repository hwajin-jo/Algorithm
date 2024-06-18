package baekjoon.no7490;

import java.util.*;

public class Main {

    static int n;
    static int[] num;
    static char[] temp;
    static char[] operator = {'+', '-', ' '};
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            num = new int[n];
            temp = new char[n - 1];
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                num[i] = i + 1;
            }

            solve(0);

            Collections.sort(list);

            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    static void solve(int depth) {
        if (depth == n - 1) {
            int nIdx = 0;
            int oIdx = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n * 2 - 1; i++) {
                if (i % 2 == 0) {
                    sb.append(num[nIdx++]);
                } else {
                    sb.append(temp[oIdx++]);
                }
            }

            String s = sb.toString();
            s = s.replaceAll(" ", "");
            s = s.replaceAll("[+-]", " ");
            if (isTotalZero(s)) {
                list.add(sb.toString());
            }
            return;
        }

        for (char c : operator) {
            temp[depth] = c;
            solve(depth + 1);
        }
    }

    private static boolean isTotalZero(String s) {
        String[] arr = s.split(" ");

        int idx = 0;
        int sum = Integer.parseInt(arr[idx++]);
        for (char c : temp) {
            if (c == ' ') continue;
            if (c == '+') {
                sum += Integer.parseInt(arr[idx++]);
            } else {
                sum -= Integer.parseInt(arr[idx++]);
            }
        }

        return sum == 0;
    }
}
