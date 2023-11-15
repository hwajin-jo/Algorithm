package baekjoon.no10597;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] check = new int[101];
    static char[] input;
    static List<Integer> ansList = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.next().toCharArray();

        n = input.length > 9 ? (input.length - 9) / 2 + 9 : input.length;

        solve(0);

    }

    static void solve(int index) {
        // base_case
        if (index >= input.length) {
            String result = "";

            for (Integer num : ansList) {
                System.out.print(result + " " + num);
            }
            System.exit(0);
        }

        // recursive_case
        int target1 = atoi(index, 1);
        if (target1 <= n && check[target1] == 0) {
            check[target1] = index + 1;
            ansList.add(target1);
            solve(index + 1);
            ansList.remove(ansList.size() - 1);
            check[target1] = 0;
        }

        if (index + 1 >= input.length) return;

        int target2 = atoi(index, 2);
        if (target2 <= n && check[target2] == 0) {
            check[target2] = index + 1;
            ansList.add(target2);
            solve(index + 2);
            ansList.remove(ansList.size() - 1);
            check[target2] = 0;
        }
    }

    static int atoi(int index, int size) {
        int result = 0;

        for (int i = index; i < index + size; i++) {
            result *= 10;
            result += input[i] - '0';
        }

        return result;
    }

}
