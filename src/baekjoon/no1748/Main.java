package baekjoon.no1748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 1;
        int gubun = 10;
        int totalNum = 0;
        for (int i = 1; i <= n; i++)
        {
            if (i % gubun == 0)
            {
                num += 1;
                gubun *= 10;
            }
            totalNum += num;
        }

        System.out.println(totalNum);
    }
}
