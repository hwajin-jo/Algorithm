package baekjoon.no23325;

import java.util.Scanner;

public class Main {

    static char[] data;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        data = sc.next().toCharArray();

        solve(0, 0, false);
    }

    static void solve(int idx, int total,  boolean isOperator) {
        if (idx == data.length) {
            ans = Math.max(ans, total);
        }

        if (isOperator) {
            if (data[idx] == '-') {
                
            }
        } else {
           if (data[idx] == '-') {
               solve(idx + 1, total + data[idx] - '0', true);
           } else {
               solve(idx + 1, total + data[idx] - '0', true);
               total += data[idx] - '0';
               total += data[idx + 1] - '0';
               solve(idx + 2, total, true);
               total -= data[idx] - '0';
               total -= data[idx + 1] - '0';
           }
        }
    }
}
