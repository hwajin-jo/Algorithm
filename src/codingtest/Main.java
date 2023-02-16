package codingtest;

import java.util.Scanner;

// 2023/02/04 현대 오토에버 시험문제 복기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] str = input.split("-");

        StringBuilder answer = new StringBuilder();
         for (String temp : str) {
            answer.append(temp.charAt(0));
        }

        System.out.println(answer);
    }
}
